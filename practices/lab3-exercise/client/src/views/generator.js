export default function (store) {
	return class GeneratorComponent extends window.HTMLElement {
		constructor () {
			super();
			this.store = store;

			// TODO: render generator initial view

			// TODO: subscribe to store on change event

			// TODO: add click event

		}
	};
}
