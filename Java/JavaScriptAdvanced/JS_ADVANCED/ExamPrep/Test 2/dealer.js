const { assert } = require('chai');
let dealership = {
    newCarCost: function(oldCarModel, newCarPrice) {

        let discountForOldCar = {
            'Audi A4 B8': 15000,
            'Audi A6 4K': 20000,
            'Audi A8 D5': 25000,
            'Audi TT 8J': 14000,
        }

        if (discountForOldCar.hasOwnProperty(oldCarModel)) {
            let discount = discountForOldCar[oldCarModel];
            let finalPrice = newCarPrice - discount;
            return finalPrice;
        } else {
            return newCarPrice;
        }
    },

    carEquipment: function(extrasArr, indexArr) {
        let selectedExtras = [];
        indexArr.forEach(i => {
            selectedExtras.push(extrasArr[i])
        });

        return selectedExtras;
    },

    euroCategory: function(category) {
        if (category >= 4) {
            let price = this.newCarCost('Audi A4 B8', 30000);
            let total = price - (price * 0.05)
            return `We have added 5% discount to the final price: ${total}.`;
        } else {
            return 'Your euro category is low, so there is no discount from the final price!';
        }
    }
}
describe('Test the DealerShip', () => {
    describe('newCarCost', () => {
        // model is supported -> price reduced by model value
        // model is not supported -> no discount
        it('returns original price, when model not supported', () => {
            assert.equal(dealership.newCarCost('a', 1), 1);
        });
        it('returns discounted price', () => {
            assert.equal(dealership.newCarCost('Audi A4 B8', 30000), 15000);
        });
    });
    describe('carEquipment', () => {
        // single element, single pick
        // test overloading -> multiple elements, multiple picks
        it('single element, single pick', () => {
            assert.deepEqual(dealership.carEquipment(['a'], [0]), ['a']);
        });
        it('multiple elements, single pick', () => {
            assert.deepEqual(dealership.carEquipment(['a', 'b', 'c'], [1]), ['b']);
        });
        it('multiple elements, multiple picks', () => {
            assert.deepEqual(dealership.carEquipment(['a', 'b', 'c'], [0, 2]), ['a', 'c']);
        });
    });
    describe('euroCategory', () => {
        // category is bellow
        // category is above
        // category is at border-case
        it('category below', () => {
            assert.equal(dealership.euroCategory(1), ('Your euro category is low, so there is no discount from the final price!'));
        });
        it('category above', () => {
            assert.equal(dealership.euroCategory(5), (`We have added 5% discount to the final price: 14250.`));
        });
        it('category board', () => {
            assert.equal(dealership.euroCategory(4), (`We have added 5% discount to the final price: 14250.`));
        });
    });
});