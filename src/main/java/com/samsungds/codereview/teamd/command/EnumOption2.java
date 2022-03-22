package com.samsungds.codereview.teamd.command;

import com.samsungds.codereview.teamd.constant.Constants;

public enum EnumOption2 {
    employeeNum {
        @Override
        String getSearchKey(String option) {
            return Constants.EMPLOYEE_NUM;
        }
    },
    name {
        @Override
        String getSearchKey(String option){
            if (Constants.OPTION2_NAME_FIRST.equalsIgnoreCase(option))
                return Constants.OPTION2_NAME_FIRST_FIELDNAME;
            else if (Constants.OPTION2_NAME_LAST.equalsIgnoreCase(option))
                return Constants.OPTION2_NAME_LAST_FIELDNAME;
            return Constants.EMPLOYEE_NAME;
        }
    },
    cl {
        @Override
        String getSearchKey(String option) {
            return Constants.EMPLOYEE_CAREER_LEVEL;
        }
    },
    phoneNum {
        @Override
        String getSearchKey(String option) {
            if(Constants.OPTION2_PHONENUM_MID.equalsIgnoreCase(option))
                return Constants.OPTION2_PHONENUM_MID_FIELDNAME;
            else if (Constants.OPTION2_PHONENUM_LAST.equalsIgnoreCase(option))
                return Constants.OPTION2_PHONENUM_LAST_FIELDNAME;
            return Constants.EMPLOYEE_PHONENUM;
        }
    },
    birthday {
        @Override
        String getSearchKey(String option) {
            if (Constants.OPTION2_BIRTHDAY_YEAR.equalsIgnoreCase(option))
                return Constants.OPTION2_BIRTHDAY_YEAR_FIELDNAME;
            else if (Constants.OPTION2_BIRTHDAY_MONTH.equalsIgnoreCase(option))
                return Constants.OPTION2_BIRTHDAY_MONTH_FIELDNAME;
            else if (Constants.OPTION2_BIRTHDAY_DAY.equalsIgnoreCase(option))
                return Constants.OPTION2_BIRTHDAY_DAY_FIELDNAME;
            return Constants.EMPLOYEE_BIRTHDAY;
        }
    },
    certi {
        @Override
        String getSearchKey(String option) {
            return Constants.EMPLOYEE_CERTI;
        }
    };

    abstract String getSearchKey(String strOpt);
}
