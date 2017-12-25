package main

import (
	"encoding/json"
	"fmt"
	"net/http"
	"strconv"
	"time"

	"github.com/gorilla/handlers"
	"github.com/gorilla/mux"
)

var reservations []Reservation

// Reservation is the base unit of the table reservation simulation
type Reservation struct {
	ID     int    `json:"id"`
	Name   string `json:"name"`
	Size   int32  `json:"size"`
	Status string `json:"status"`
}

// handlers
func hello(w http.ResponseWriter, r *http.Request) {
	fmt.Fprintln(w, "Hello Reservation")
}

func getReservation(w http.ResponseWriter, r *http.Request) {
	vars := mux.Vars(r)
	id, err := strconv.Atoi(vars["id"])
	if err != nil {
		http.Error(w, "Please make sure id is number fomrat", 400)
		return
	}
	result := reservations[id-1]
	json.NewEncoder(w).Encode(result)
}

func reserve(w http.ResponseWriter, r *http.Request) {
	var reservation Reservation
	if r.Body == nil {
		http.Error(w, "Please include reservation in request body", 400)
		return
	}
	err := json.NewDecoder(r.Body).Decode(&reservation)
	if err != nil {
		http.Error(w, err.Error(), 400)
		return
	}
	nextIndex := len(reservations)
	newReservation := Reservation{nextIndex + 1, reservation.Name, reservation.Size, "queue"}
	reservations = append(reservations, newReservation)
	json.NewEncoder(w).Encode(newReservation)
	go func(nextIndex int) {
		time.Sleep(time.Second * 2)
		reservations[nextIndex].Status = "waiting"
		time.Sleep(time.Second * 5)
		reservations[nextIndex].Status = "done"
	}(nextIndex)
}

func main() {
	index := http.FileServer(http.Dir("static"))
	static := http.StripPrefix("/static/", http.FileServer(http.Dir("static")))
	r := mux.NewRouter()
	r.Handle("/", index).Methods("GET")
	r.PathPrefix("/static").Handler(static)
	r.HandleFunc("/hello", hello).Methods("GET")
	r.HandleFunc("/services/reservation/{id}", getReservation).Methods("GET")
	r.HandleFunc("/services/reservations", reserve).Methods("POST")

	headersOk := handlers.AllowedHeaders([]string{"X-Requested-With", "Content-Type"})
	originsOk := handlers.AllowedOrigins([]string{"*"})
	methodsOk := handlers.AllowedMethods([]string{"GET", "HEAD", "POST", "PUT", "OPTIONS"})

	http.Handle("/", handlers.CORS(headersOk, originsOk, methodsOk)(r))
	http.ListenAndServe(":9000", nil)
}
