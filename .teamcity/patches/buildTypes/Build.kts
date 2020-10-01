package patches.buildTypes

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildFeatures.CommitStatusPublisher
import jetbrains.buildServer.configs.kotlin.v2019_2.buildFeatures.commitStatusPublisher
import jetbrains.buildServer.configs.kotlin.v2019_2.ui.*

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, change the buildType with id = 'Build'
accordingly, and delete the patch script.
*/
changeBuildType(RelativeId("Build")) {
    features {
        val feature1 = find<CommitStatusPublisher> {
            commitStatusPublisher {
                publisher = github {
                    githubUrl = "https://api.github.com"
                    authType = personalToken {
                        token = "%commitStatusPublisher.apiKey%"
                    }
                }
            }
        }
        feature1.apply {
            publisher = github {
                githubUrl = "https://api.github.com"
                authType = personalToken {
                    token = "credentialsJSON:d2d6ff31-56f1-4893-a448-f7a517da6c88"
                }
            }
        }
    }

    requirements {
        remove {
            equals("system.Octopus.Purpose", "Build")
        }
        remove {
            exists("system.Octopus.DotnetSdk3.1")
        }
        remove {
            exists("system.Octopus.DotnetSdk472")
        }
        add {
            equals("system.Octopus.Purpose", "Build", "RQ_2")
        }
        add {
            exists("system.Octopus.DotnetSdk3.1", "RQ_3")
        }
        add {
            exists("system.Octopus.DotnetSdk472", "RQ_4")
        }
        add {
            exists("DotNetFrameworkTargetingPack4.7.2_Path")
        }
        add {
            exists("DotNetCoreSDK3.1_Path")
        }
    }

    expectDisabledSettings()
    updateDisabledSettings("RQ_2", "RQ_3", "RQ_4")
}
