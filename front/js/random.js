class RandomList {
    constructor(root) {
        this.root = root;
        this.list = [];
        this.fillRandomValues();
        this.init();
    }

    init () {
        // using innerHTML with template string, you achieve a simple template
        // rendering
        this.root.innerHTML = `<ul>
            ${this.getListItems()}
        </ul>`
    }

    getListItems () {
        let result = '';
        for (var i = 0; i < this.list.length; i++) {
            result += `<li>${this.list[i]}</li>`;
        }
        return result;
        // return this.list.map(item => {
        //     return `<li>${item}</li>`;
        // }).reduce((a, b) => {
        //     return a + b;
        // }, '');
    }

    fillRandomValues () {
        let size = this.randomNum();
        for (var i = 0; i < size; i ++) {
            this.list.push(this.randomNum());
        }
    }

    randomNum () {
        return Math.floor(Math.random() * 100);
    }
}

new RandomList(document.querySelector('h1'));
