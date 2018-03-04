export default function (store) {
	return class GiphyComponent extends window.HTMLElement {
		constructor () {
			super();
			this.store = store;

			this.onStateChange = this.handleStateChange.bind(this);
		}

		handleStateChange (newState) {
			this.innerHTML = this.render();
			console.log('CounterComponent#stateChange', this, newState);
		}

		connectedCallback () {
			console.log(this,this.dataset.id);
			this.id = this.dataset.id;
			this.innerHTML = this.render();
			this.store.subscribe(this.onStateChange);
		}

		disconnectedCallback () {
			this.store.unsubscribe(this.onStateChange);
		}

		render () {
			return `<img src="${this.store.state.images[this.id]}"></img>`;
		}
	};
}

