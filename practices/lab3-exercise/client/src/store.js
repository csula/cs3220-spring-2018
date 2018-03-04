// Store is heavily inspired by Redux from React pattern to handle state management
export default class Store {
	/**
	 * Create a new store with specific reducer and optionally initial state
	 * @constructor
	 * @param {function} reducer - the reducer to mutate state
	 * @param {initialState} object - the initial state
	 */
	constructor (reducer, initialState = {}) {
		this.reducer = reducer;
		// listeners are internal state to keep track of which reducers to call in this
		// order
		this.listeners = [];
		// initial internal state
		this.__state = initialState;
	}

	/**
	 * Overwrites getter for `state` variable to be READ-ONLY state through
	 * deepCopy method
	 */
	get state () {
		return deepCopy(this.__state);
	}

	/**
	 * `dispatch` controls state changes. One should use only dispatch to show
	 * intent to change state and go through reducer to change so
	 * @param {object} action - action should contain both `type` and `payload`
	 */
	dispatch (action) {
		this.__state = this.reducer(this.state, action);
		this.listeners.forEach(l => l(this.state, action));
	}

	/**
	 * subscribe allows consumer to listen for state changes
	 * @param {function} listener - function contains state and action as its arguments
	 */
	subscribe (listener) {
		this.listeners.push(listener);
	}

	/**
	 * unsubscribe allows consumer to stop listening to state changes
	 * @param {function} listener - the function consumer subscribed earlier
	 */
	unsubscribe (listener) {
		this.listeners = this.listeners.filter(l => l != listener);
	}
}

/**
 * deepCopy is helper method to create deep copy of certain object
 * @param {object} obj - the object to copy from
 */
function deepCopy(obj) {
	return JSON.parse(JSON.stringify(obj));
}
