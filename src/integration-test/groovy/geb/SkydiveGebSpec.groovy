package geb

import grails.test.mixin.integration.Integration
import grails.transaction.*

import spock.lang.*
import geb.spock.*

/**
 * See http://www.gebish.org/manual/current/ for more instructions
 */
@Integration
@Rollback
class SkydiveGebSpec extends GebReportingSpec {

    def setup() {
        //bigger for screen grab checking
        def dim = new org.openqa.selenium.Dimension(1280,800)
        driver.manage().window().setSize(dim) 
    }

    def cleanup() {
    }

    void "sanity check root"() {
        when:"The home page is visited"
            go '/'

        then:"The title is correct"
        	title == "Welcome to Grails"
            def html = driver.pageSource //the entire page
            html.contains('Congratulations, you have successfully started your first Grails application!')

        when:"Skydive Controller is clicked"
            $('#controllers li.controller a',0).click()
            //this will allow you to errors out and leave the browser open if quitCachedDriverOnShutdown=true in gebconfig
            //waitFor(1) {false}
        then:
            title == "Skydive List"

    }

    void "add new"() {
        when:"click new"
            go '/skydive/index'
            assert title == "Skydive List"
            //click add
            $('div.nav li a.create').click()

        then:"should see form"
            title == "Create Skydive"

        when:"Form is filled out"

            $("form").altitude = 13000
            $("form").jumpNum = 2100
            //$("form").dropzone = "Chicago" <-shortcut for below
            $("form").find("input", name: "dropzone").value("Chicago")

            $("form").date_day = 21 ; $("form").date_month = "August" ; $("form").date_year = "2015"

            $('#create').click()

        then:
            title == "Show Skydive"
            assert $("#jumpNum-label").next().text() == "2,100" 

            //can also grab the domain and check
            def skydive = Skydive.findByJumpNum(2100)
            skydive.altitude == 13000

    }
}
