const { expect } = require('chai');
const rgbToHexColor = require('./RBGtoHEX');
describe('RGBtoHEX', () => {
    it('convert black to hex', () => {
        expect(rgbToHexColor(0, 0, 0)).to.equal('#000000');
    });
    it('convert white to hex', () => {
        expect(rgbToHexColor(255, 255, 255)).to.equal('#FFFFFF');
    });
    it('convert red to hex', () => {
        expect(rgbToHexColor(255, 0, 0)).to.equal('#FF0000');
    });
    it('convert green to hex', () => {
        expect(rgbToHexColor(0, 255, 0)).to.equal('#00FF00');
    });
    it('convert blue to hex', () => {
        expect(rgbToHexColor(0, 0, 255)).to.equal('#0000FF');
    });
    it('return undefined for string params', () => {
        expect(rgbToHexColor('a', 'a', 'a')).to.be.undefined;
    });
    it('return undefined for negative red values', () => {
        expect(rgbToHexColor(-1, 0, 0)).to.be.undefined;
    });
    it('return undefined for red values > 255', () => {
        expect(rgbToHexColor(256, 0, 0)).to.be.undefined;
    });
    it('return undefined for negative green values', () => {
        expect(rgbToHexColor(0, -5, 0)).to.be.undefined;
    });
    it('return undefined for green values > 255', () => {
        expect(rgbToHexColor(0, 256, 0)).to.be.undefined;
    });
    it('return undefined for negative blue values', () => {
        expect(rgbToHexColor(0, 0, -3)).to.be.undefined;
    });
    it('return undefined for blue values > 255', () => {
        expect(rgbToHexColor(0, 0, 288)).to.be.undefined;
    });
    it('return undefined for values > 255', () => {
        expect(rgbToHexColor(0, 256, 0)).to.be.undefined;
    });
    //test overloading
    it('convert (151, 104, 172) to hex', () => {
        expect(rgbToHexColor(151, 104, 172)).to.equal('#9768AC');
    });
    it('convert (42, 173, 170) to hex', () => {
        expect(rgbToHexColor(42, 173, 170)).to.equal('#2AADAA');
    });
});