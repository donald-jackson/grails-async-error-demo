package co.centio

class SystemSetting {

    String optionName
    String optionValue

    static constraints = {
        optionName unique: true
    }

    static String getSettingValue(String optionName) {
        SystemSetting setting = SystemSetting.find("FROM SystemSetting ss WHERE optionName = :optionName",
            [optionName: optionName]
        );

        if (setting) {
            return setting.optionValue
        }

        return null;
    }
}
