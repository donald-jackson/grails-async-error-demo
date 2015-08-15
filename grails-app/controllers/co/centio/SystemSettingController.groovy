package co.centio

import static grails.async.Promises.task
import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

class SystemSettingController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond SystemSetting.list(params), model:[systemSettingInstanceCount: SystemSetting.count()]
    }

    def show(SystemSetting systemSettingInstance) {
        respond systemSettingInstance
    }

    def create() {
        respond new SystemSetting(params)
    }

    @Transactional
    def save(SystemSetting systemSettingInstance) {
        if (systemSettingInstance == null) {
            notFound()
            return
        }

        if (systemSettingInstance.hasErrors()) {
            respond systemSettingInstance.errors, view:'create'
            return
        }

        systemSettingInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'systemSetting.label', default: 'SystemSetting'), systemSettingInstance.id])
                redirect systemSettingInstance
            }
            '*' { respond systemSettingInstance, [status: CREATED] }
        }
    }

    def edit(SystemSetting systemSettingInstance) {
        respond systemSettingInstance
    }

    @Transactional
    def update(SystemSetting systemSettingInstance) {
        if (systemSettingInstance == null) {
            notFound()
            return
        }

        if (systemSettingInstance.hasErrors()) {
            respond systemSettingInstance.errors, view:'edit'
            return
        }

        systemSettingInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'SystemSetting.label', default: 'SystemSetting'), systemSettingInstance.id])
                redirect systemSettingInstance
            }
            '*'{ respond systemSettingInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(SystemSetting systemSettingInstance) {

        if (systemSettingInstance == null) {
            notFound()
            return
        }

        systemSettingInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'SystemSetting.label', default: 'SystemSetting'), systemSettingInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'systemSetting.label', default: 'SystemSetting'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }

    def showVariableAsync() {
        boolean asyncEnabled = Boolean.valueOf(SystemSetting.getSettingValue('testOption')).booleanValue()
        task {
            if(asyncEnabled) {
                render "Async Enabled\n"
            } else {
                render "Async Disabled\n"
            }
        }
    }

    def showVariable() {
        boolean asyncEnabled = Boolean.valueOf(SystemSetting.getSettingValue('testOption')).booleanValue()
        if(asyncEnabled) {
            render "Async Enabled\n"
        } else {
            render "Async Disabled\n"
        }
    }
}
