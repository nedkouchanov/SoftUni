const assert = require('chai').assert;

function lookupChar(string, index) {
    if (typeof(string) !== 'string' || !Number.isInteger(index)) {
        return undefined;
    }
    if (string.length <= index || index < 0) {
        return "Incorrect index";
    }

    return string.charAt(index);
}
describe('charLookup', () => {
    it('Undefined for wrong parameters', () => {
        assert.isUndefined(lookupChar(1, 1));
        assert.isUndefined(lookupChar('abc', 1.2));
        assert.isUndefined(lookupChar('abc', 'a'));
    })
    it('Index CHECK', () => {
        assert.equal(lookupChar('abv', -1), 'Incorrect index');
        assert.equal(lookupChar('abv', 4), 'Incorrect index');
    })
    it('Correct result', () => {
        assert.equal(lookupChar('abv', 0), 'a');
        assert.equal(lookupChar('abv', 2), 'v');
    })
})