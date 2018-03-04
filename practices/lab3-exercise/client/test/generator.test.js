/*eslint-env node, jest */
import Generator from '../src/models/generator';
import * as mock from './mock';

const mockGenerator = mock.generator;

describe('generator models', () => {
	test('getCost should return base cost when no quantity', () => {
		const generator = new Generator(Object.assign({}, mockGenerator));
		const expected = 10;
		expect(generator.getCost()).toBe(expected);
	});

	test('getCost should return base cost when no quantity', () => {
		const generator = new Generator(Object.assign({}, mockGenerator, {quantity: 5}));
		const expected = 12.76;
		expect(generator.getCost()).toBe(expected);
	});

	test('generate should return zero values when no quantity', () => {
		const generator = new Generator(Object.assign({}, mockGenerator));
		const expected = 0;
		expect(generator.generate()).toBe(expected);
	});


	test('generate should return rate * quantiy value when there is quantity', () => {
		const generator = new Generator(Object.assign({}, mockGenerator, {quantity: 5}));
		const expected = 50;
		expect(generator.generate()).toBe(expected);
	});
});

