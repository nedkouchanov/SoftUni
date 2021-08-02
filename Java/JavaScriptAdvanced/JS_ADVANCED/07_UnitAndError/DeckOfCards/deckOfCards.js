function printDeckOfCards(cards) {
    function createCard(face, suit) {
        const validFaces = ['2', '3', '4', '5', '6', '7',
            '8', '9', '10', 'J', 'Q', 'K', 'A'
        ];
        const suitToString = {
            'S': '\u2660',
            'H': '\u2665',
            'D': '\u2666',
            'C': '\u2663',
        };
        if (validFaces.includes(face) == false) {
            return ('Invalid card: ' + face + suit);
        } else if (Object.keys(suitToString).includes(suit) == false) {
            return ('Invalid card: ' + face + suit);
        }
        return {
            face,
            suit,
            toString() {
                return `${face}${suitToString[suit]}`;
            }
        };
    }
    // TODO
    let cardArray = [];
    for (const card of cards) {
        cardFace = card.split('')[0];
        cardSuit = card.split('')[1];
        if (cardFace == 1 && cardSuit == 0) {
            cardFace = '10';
            cardSuit = card.split('')[2];
        }
        cardArray.push(createCard(cardFace, cardSuit).toString());
    }
    return cardArray.join(' ');
}
module.exports = printDeckOfCards;
//printDeckOfCards(['5S', '3D', 'QD', '1C']);