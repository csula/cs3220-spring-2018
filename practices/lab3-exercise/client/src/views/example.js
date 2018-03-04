// Dependency Injection pattern to inject store into the ExampleComponent
export default function (store) {
	return class ExampleComponent extends window.HTMLElement {
		constructor () {
			super();
			this.store = store;
			console.log('ExampleComponent#Got store', this.store);
			// initial DOM rendering
			this.textContent = this.store.state.example;

			this.onStateChange = this.handleStateChange.bind(this);

			// add click event
			this.addEventListener('click', () => {
				this.store.dispatch({
					type: 'EXAMPLE_MUTATION',
					payload: 'You clicked this element'
				});
			});
		}

		handleStateChange (newState) {
			console.log('ExampleComponent#stateChange', this);
			this.textContent = newState.example;
		}

		connectedCallback () {
			console.log('ExampleComponent#onConnectedCallback');
			this.store.subscribe(this.onStateChange);
		}

		disconnectedCallback () {
			console.log('ExampleComponent#onDisconnectedCallback');
			this.store.unsubscribe(this.onStateChange);
		}
	};
}
