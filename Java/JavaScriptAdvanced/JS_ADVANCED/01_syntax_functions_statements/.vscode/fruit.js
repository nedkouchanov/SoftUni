function solve(fruit, weight, price) {
    const weightKG =weight/1000;
    const totalPrice=weightKG*price;
    return `I need $${totalPrice.toFixed(2)} to buy ${weightKG.toFixed(2)} kilograms ${fruit}.`;
}
