/*eslint-env node, jest */
import reducer from '../src/reducer';
import constants from '../src/constants';
import * as mock from './mock';

test('should be able to increment counter on button click', () => {
	const action = {
		type: constants.actions.BUTTON_CLICK
	};
	const initialState = {
		counter: 0
	};
	const expectedState = {
		counter: 1
	};
	expect(reducer(initialState, action)).toEqual(expectedState);
});

test('should be able to set example state from "EXAMPLE_MUTATION" action', () => {
	const action = {
		type: constants.actions.EXAMPLE,
		payload: 'mutated'
	};
	const initialState = {
		example: 'hello'
	};
	const expected = action.payload;
	expect(reducer(initialState, action).example).toEqual(expected);
});

test('should be able to muate resource and generators on "BUY_GENERATOR" action', () => {
	const action = {
		type: constants.actions.BUY_GENERATOR,
		payload: {
			name: 'Grandma',
			quantity: 1
		}
	};
	const initialState = {
		counter: 10,
		generators: [ mock.generator ]
	};
	const expected = {
		counter: 0,
		generators: [ Object.assign({}, mock.generator, {quantity: 1}) ]
	};
	expect(reducer(initialState, action)).toEqual(expected);
});
