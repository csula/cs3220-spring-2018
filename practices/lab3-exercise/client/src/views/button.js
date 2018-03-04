import constants from '../constants';

export default function (store) {
	return class ButtonComponent extends window.HTMLElement {
		constructor () {
			super();
			this.store = store;
		}

		connectedCallback () {
			console.log('ExampleComponent#onConnectedCallback');
			this.innerHTML = '<button>Click me</button>';
			this.addEventListener('click', () => {
				console.log('Hello click');
				const url = 'https://api.giphy.com/v1/gifs/random?api_key=dc6zaTOxFJmzC&tag=cat';
				fetch(url)
					.then(resp => resp.json())
					.then(d => d.data.image_url)
					.then(url => {
						// display image
						this.store.dispatch({
							type: 'DISPLAY_IMAGE',
							payload: url
						});
					});
				this.store.dispatch({
					type: constants.actions.BUTTON_CLICK
				});
			});
		}

		disconnectedCallback () {
			console.log('ExampleComponent#onDisconnectedCallback');
			this.store.unsubscribe(this.onStateChange);
		}
	};
}
