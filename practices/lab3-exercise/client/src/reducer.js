import constants from './constants';

var index = 0;

export default function reducer (state, action) {
	switch (action.type) {
	case constants.actions.EXAMPLE:
		state.example = action.payload;
		return state;
	case constants.actions.BUTTON_CLICK:
		state.counter ++;
		return state;
	case 'DISPLAY_IMAGE':
		state.images[index] = action.payload;
		index = ++index % state.images.length;
		return state;
	default:
		return state;
	}
}

