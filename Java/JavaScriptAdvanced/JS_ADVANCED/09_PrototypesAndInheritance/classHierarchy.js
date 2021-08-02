function classes() {

    class Figure {
        constructor(units = 'cm') {
            this.units = units;
        }

        get area() {
            return this.area;
        }

        changeUnits(unit) {
            this.units = unit;
        }
        toString() {
            return `Figures units: ${this.units}`;
        }
    }
    class Circle extends Figure {
        constructor(radius) {
            super();
            this.radius = radius;
        }
        get area() {
            let result = Math.PI * this.radius * this.radius;
            if (this.units == 'm') {
                result /= 100;
            } else if (this.units == 'mm') {
                result *= 100;

            }
            return result;
        }
        toString() {
            let r = this.radius;
            if (this.units === 'm') {
                r /= 10;

            } else if (this.units === 'mm') {
                r *= 10;
            }
            return `Figures units: ${this.units} Area: ${this.area} - radius: ${r}`;
        }
    }

    class Rectangle extends Figure {
        constructor(width, height, units) {
            super(units);
            this.width = width;
            this.height = height;
        }
        get area() {
            let result = this.width * this.height;
            if (this.units == 'm') {
                result /= 100;
            } else if (this.units == 'mm') {
                result *= 100;
            }
            return result;
        }
        toString() {
            let h = this.height;
            let w = this.width;
            if (this.units === 'm') {
                h /= 10;
                w /= 10;
            } else if (this.units === 'mm') {
                h *= 10;
                w *= 10;
            }
            return `Figures units: ${this.units} Area: ${this.area} - width: ${this.area/h}, height: ${this.area/w}`;
        }
    }

    return {
        Figure,
        Circle,
        Rectangle
    };
}