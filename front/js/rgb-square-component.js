class RGBSqaure {
    /**
     * Pass the dom element into the JavaScript class to attach event & data
     */
    constructor(root) {
        this.root = root;
        this.colors = ['--red', '--green', '--blue'];
        this.colorIndex = -1; // no color
        this.onClick = () => this._updateColor();
        this.init();
    }

    // define its life cycle with init
    init () {
        this.root.addEventListener('click', this.onClick);
    }

    // on destroy, it should remove all the event listeners so it doesn't create
    // memory leak
    destroy () {
        this.root.removeEventListener('click', this.onClick);
    }

    _updateColor () {
        let oldClass = this.colorClass(this.colorIndex);
        let newClass = this.colorClass(++this.colorIndex);
        if (oldClass) {
            this.root.classList.remove(oldClass);
        }
        this.root.classList.add(newClass);
        if (this.colorIndex === this.colors.length) {
			this.colorIndex = -1;
        }
    }

    colorClass (i) {
        if (i < 0) {
            return '';
        }
        return this.colors[i];
    }
}

const rgbSquares = document.querySelectorAll('.rgb-square');
for (var i = 0; i < rgbSquares.length; i ++) {
	new RGBSqaure(rgbSquares[i]);
}




















































