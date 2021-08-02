const { expect } = require('chai');
const result = require('./deckOfCards');

describe('deckOfCards', () => {
    it('works properly with sampl array', () => {
        expect(result(['AS', '10D', 'KH', '2C'])).to.equal('A♠ 10♦ K♥ 2♣');
    });
    it('error message with 1C', () => {
        expect(result(['5S', '3D', 'QD', '1C'])).to.equal('5♠ 3♦ Q♦ Invalid card: 1C');
    });
});