function filterEmp(data, criteria) {
    const dataArr = JSON.parse(data);
    const [property, value] = criteria.split('-');
    const result = [];
    for (const employee of dataArr) {
        if (employee[property] === value) {
            result.push(employee);
        }
    }
    const len = result.length;
    for (let i = 0; i < len; i++) {
        result.push(`${i}. ${result[i]['first_name']} ${result[i]['last_name']} - ${result[i].email}`);
    }
    result.splice(0, result.length / 2);
    return result.join('\n');
}
console.log(filterEmp(
    `[{"id": "1",
    "first_name": "Ardine",
    "last_name": "Bassam",
    "email": "abassam0@cnn.com",
    "gender": "Female"
  }, {
    "id": "2",
    "first_name": "Kizzee",
    "last_name": "Jost",
    "email": "kjost1@forbes.com",
    "gender": "Female"
  },  
{
    "id": "3",
    "first_name": "Evanne",
    "last_name": "Maldin",
    "email": "emaldin2@hostgator.com",
    "gender": "Male"
  }]`,
    'gender-Female'
));