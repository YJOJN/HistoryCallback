pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        maven { url = uri ("https://jitpack.io")}
        maven { url = uri ("https://maven/aliyun.com/repository/public")}
        google()
        mavenCentral()
    }
}

rootProject.name = "AndroidHistoryEchoes"
include(":app")
 