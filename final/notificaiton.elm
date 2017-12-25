import Html exposing (..)
import Html.Events exposing (onClick, onInput)
import Html.Attributes exposing (..)
import Http
import Json.Decode as Decode
import Json.Encode as Encode
import Time exposing (Time, second)

main =
    Html.program
    {
        init = init,
        view = view,
        update = update,
        subscriptions = subscriptions
    }

-- model
createReservationUrl : String
createReservationUrl = "services/reservations"
getReservationUrl : String
getReservationUrl = "services/reservation/"
type alias Model =
    {
        customerName: String,
        partySize: Int,
        phone: String,
        url: String,
        waiting: Bool,
        done: Bool,
        errorMessage: String
    }
type alias Reservation =
    {
        id: Int,
        name: String,
        size: Int,
        status: String
    }

init : (Model, Cmd Msg)
init =
    (Model "" 2 "" "" False False "", Cmd.none)


-- update
type Msg =
    Reserve
    | Name String
    | PartySize String
    | NewReservation (Result Http.Error Reservation)
    | ReservationResult (Result Http.Error Reservation)
    | ReserveAgain
    | Tick Time


update : Msg -> Model -> (Model, Cmd Msg)
update msg model =
    case msg of
        Reserve ->
            (model, makeReservation createReservationUrl (convertToReservation model))

        Tick _ ->
            if model.waiting then (model, getReservation model.url) else (model, Cmd.none)

        Name name ->
            ({ model | customerName = name}, Cmd.none)

        PartySize size ->
            ({ model | partySize = Result.withDefault 0 (String.toInt size)}, Cmd.none)

        ReserveAgain ->
            ({model | done = False}, Cmd.none)

        ReservationResult (Ok reservation) ->
            ({model | waiting = True, url = getReservationUrl ++ (toString reservation.id)}, getReservation (getReservationUrl ++ (toString reservation.id)))

        ReservationResult (Err err) ->
            (model, Cmd.none)

        NewReservation (Ok reservation) ->
            if reservation.status == "done" then ({model | waiting = False, done = True}, Cmd.none) else (model, Cmd.none)

        NewReservation (Err err) ->
            case err of
                Http.BadUrl url ->
                    ( { model | waiting = False, errorMessage = "Error: bad url. Contact developer for the fix." }, Cmd.none)
                Http.Timeout ->
                    ( { model | waiting = False, errorMessage = "Error: request timeout. Try again later." }, Cmd.none)
                Http.NetworkError ->
                    ( { model | waiting = False, errorMessage = "Error: Network error" }, Cmd.none )
                Http.BadStatus resp ->
                    ( { model | waiting = False, errorMessage = "Error: BadStatus " ++ resp.body }, Cmd.none )
                Http.BadPayload body resp ->
                    ( { model | waiting = False, errorMessage = "Error: BadPayload " ++ body ++ " " ++ resp.body }, Cmd.none )

convertToReservation : Model -> Reservation
convertToReservation model = {
    id = 0,
    name = model.customerName,
    size = model.partySize,
    status = "" }

makeReservation : String -> Reservation -> Cmd Msg
makeReservation url reservation =
    let
        request = Http.post url (encodeReservation reservation) decodeReservation
    in
        Http.send ReservationResult request
encodeReservation : Reservation -> Http.Body
encodeReservation reservation =
    Http.jsonBody <| Encode.object [
        ("id", Encode.int reservation.id),
        ("name", Encode.string reservation.name),
        ("size", Encode.int reservation.size),
        ("status", Encode.string reservation.status)
    ]


getReservation : String -> Cmd Msg
getReservation url =
    let
        request =
            Http.get url decodeReservation
    in
        Http.send NewReservation request

decodeReservation : Decode.Decoder Reservation
decodeReservation =
    Decode.map4 Reservation
    (Decode.field "id" Decode.int)
    (Decode.field "name" Decode.string)
    (Decode.field "size" Decode.int)
    (Decode.field "status" Decode.string)


-- view
view : Model -> Html Msg
view model =
    section []
    [
        section [class (if model.waiting then "loading reservation" else "reservation"), style [("display", if model.done then "none" else "")]]
        [
            h2 [] [text "Reservation"],
            div [style [("display", if model.waiting then "none" else "block")]] [
                div [class "input-container"] [
                    label [for "name"] [text "Customer Name"],
                    input [id "name", placeholder "John Doe", onInput Name] []
                ],
                div [class "input-container"] [
                    label [for "party_size"] [text "Party Size"],
                    input [type_ "number", id "party_size", placeholder "2", onInput PartySize] []
                ]
            ],
            div [style [("display", if model.waiting then "" else "none")]] [
                div [class "sk-folding-cube"] [
                    div [class "sk-cube1 sk-cube"] [],
                    div [class "sk-cube2 sk-cube"] [],
                    div [class "sk-cube4 sk-cube"] [],
                    div [class "sk-cube3 sk-cube"] []
                ],
                text "Waiting ..."
            ],
            div [class "feedback"] [
                text model.errorMessage
            ],
            button [class "btn", onClick Reserve, style [("display", if model.waiting then "none" else "")]] [text "Reserve"]
        ],
        div [class "result", style [("display", if model.done then "" else "none")]] [
            p [class "fill"] [text "Your reservation is now ready! Follow server to your table."],
            button [class "btn", onClick ReserveAgain] [text "Back to Reservation"]
        ]
    ]

-- Subscriptions

subscriptions : Model -> Sub Msg
subscriptions model =
    Time.every second Tick


