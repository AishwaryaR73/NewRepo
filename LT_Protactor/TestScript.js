const { browser, element, by, $ } = require("protractor")



describe('smokeTest', function(){


    beforeAll(function(){

        browser.get('https://juliemr.github.io/protractor-demo/')

    })

    afterAll(()=>{

        browser.sleep(3000)
    })


    it('Four Digit Number', ()=>{

  
        element(by.css('input[ng-model="first"]')).sendKeys('1211')

        element(by.css('input[ng-model="second"]')).sendKeys('2122')

        $('#gobutton').click()

       
        expect($('.ng-binding').getText()).toEqual("3333")

    })


    
    it('Add Three digit Number', ()=>{

 
        element(by.css('input[ng-model="first"]')).sendKeys('121')

        element(by.css('input[ng-model="second"]')).sendKeys('212')

        $('#gobutton').click()
        
        expect($('.ng-binding').getText()).toEqual("334")

    })

    it('Add Two digit Number', async ()=>{

 
        element(by.css('input[ng-model="first"]')).sendKeys('12')

        element(by.css('input[ng-model="second"]')).sendKeys('21')

        $('#gobutton').click()
        
        let result = await $('.ng-binding').getText()
        console.log("Result : " + result);

        expect($('.ng-binding').getText()).toEqual("33")

    })


    it('Add one digit Number', ()=>{

 
        element(by.css('input[ng-model="first"]')).sendKeys('9')

        element(by.css('input[ng-model="second"]')).sendKeys('8')

        $('#gobutton').click()
        
        expect($('.ng-binding').getText()).toEqual("17")

    })


})
