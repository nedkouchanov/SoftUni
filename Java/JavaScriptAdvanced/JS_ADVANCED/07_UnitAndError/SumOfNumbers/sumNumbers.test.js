const { assert } = require('chai');
const sum = require('./sumNumbers');

describe('Sum numbers', () => {
    it('sums single number', () => {
        assert.equal(sum([1]), 1);
    });

    //Test OverLoading
    it('sums multiple numbers', () => {
        assert.equal(sum([1, 1]), 2);
    });

    it('sums diferent numbers', () => {
        assert.equal(sum([2, 3, 4]), 9);
    });
});