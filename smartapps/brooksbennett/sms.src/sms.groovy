/**
 *  SMS
 *
 *  Copyright 2016 Brooks Bennett
 *
 */
definition(
    name: "SMS",
    namespace: "BrooksBennett",
    author: "Brooks Sky Bennett",
    description: "SMS Test",
    category: "Convenience",
    iconUrl: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience.png",
    iconX2Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png",
    iconX3Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png")


preferences {
	section ("Send text alerts to:") {
        input("recipients", "contact", title: "Name") {
            input "phone1", "phone", title: "Phone Number 1", required: true
        }
	}
}

def installed() {
	log.debug "Installed with settings: ${settings}"

	initialize()
}

def updated() {
	log.debug "Updated with settings: ${settings}"

	unsubscribe()
	initialize()
}

def initialize() {
	sendSms(phone1, "some message")
}

// TODO: implement event handlers
