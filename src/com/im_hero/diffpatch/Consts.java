package com.im_hero.diffpatch;

public interface Consts {

    interface Paths {
        String FOLDER_APK_FILES = "WEB-INF/apks";
        String FOLDER_APK_PATCH_FILES = "WEB-INF/apks/patchs";
    }

    interface Keys {
        String APP_CURRENT_VERSION_CODE = "current-version-code";
        String APP_LATEST_VERSION_CODE = "latest-version-code";
        String APP_CURRENT_VERSION_NAME = "current-version-name";
        String APP_LATEST_VERSION_NAME = "latest-version-name";
    }

    interface Default {
        String DEFAULT_VERSION_CODE = "1";
        String DEFAULT_VERSION_NAME = "DiffPatch-1.0";
    }
}
