var dom = document.querySelector('.rgb-square');

var list = ['--red', '--blue', '--green'];
var counter = -1;

dom.addEventListener('click', function () {
	// fill in the logic to change color of the square
	// hint: you can use https://developer.mozilla.org/en-US/docs/Web/API/Element/classList to change color
	console.log('clicked');
	if (counter >= 0) {
	    dom.classList.remove(list[counter]);
	}
	counter ++;
	if (counter === list.length) {
        counter = 0;
	}
	dom.classList.add(list[counter]);
	console.log(counter);
	console.log(list[counter]);
});
