var OT = {
    "on": function () {},
    "off": function () {},
    "once": function () {},
    "dispatchEvent": function () {},
    "trigger": function () {},
    "emit": function () {},
    "addEventListener": function () {},
    "removeEventListener": function () {},
    "__testOnly": {
        "events": function () {},
        "removeAllListenersNamed": function () {},
        "removeListeners": function () {},
        "addListeners": function () {},
        "resetEventingSpies": function () {}
    },
    "$": function () {},
    "APIKEY": {},
    "AnalyserAudioLevelSampler": function () {},
    "Analytics": function () {},
    "Anvil": {
        "getRequestParams": function () {},
        "getErrorsFromHTTP": function () {},
        "getErrorsFromResponse": function () {},
        "get": function () {}
    },
    "Archive": function () {},
    "ArchiveEvent": function () {},
    "ArchiveUpdatedEvent": function () {},
    "AudioLevelTransformer": function () {},
    "AudioLevelUpdatedEvent": function () {},
    "Capabilities": function () {},
    "Chrome": function () {},
    "Connection": function () {},
    "ConnectionCapabilities": function () {},
    "ConnectionEvent": function () {},
    "ConnectivityAttemptPinger": function () {},
    "DEBUG": {},
    "DestroyedEvent": function () {},
    "Dialogs": {
        "Plugin": {
            "promptToInstall": function () {},
            "promptToReinstall": function () {},
            "updateInProgress": function () {},
            "updateComplete": function () {}
        }
    },
    "ERROR": {},
    "EnvLoadedEvent": function () {},
    "Error": function () {},
    "Event": function () {},
    "ExceptionCodes": {
        "JS_EXCEPTION": {},
        "AUTHENTICATION_ERROR": {},
        "INVALID_SESSION_ID": {},
        "CONNECT_FAILED": {},
        "CONNECT_REJECTED": {},
        "CONNECTION_TIMEOUT": {},
        "NOT_CONNECTED": {},
        "INVALID_PARAMETER": {},
        "P2P_CONNECTION_FAILED": {},
        "API_RESPONSE_FAILURE": {},
        "TERMS_OF_SERVICE_FAILURE": {},
        "UNABLE_TO_PUBLISH": {},
        "UNABLE_TO_SUBSCRIBE": {},
        "UNABLE_TO_FORCE_DISCONNECT": {},
        "UNABLE_TO_FORCE_UNPUBLISH": {},
        "PUBLISHER_ICE_WORKFLOW_FAILED": {},
        "SUBSCRIBER_ICE_WORKFLOW_FAILED": {},
        "UNEXPECTED_SERVER_RESPONSE": {},
        "REPORT_ISSUE_ERROR": {}
    },
    "ExceptionEvent": function () {},
    "getDevices": function () {},
    "GetStatsAudioLevelSampler": function () {},
    "HAS_REQUIREMENTS": {},
    "INFO": {},
    "IntervalRunner": function () {},
    "IssueReportedEvent": function () {},
    "LOG": {},
    "MediaStoppedEvent": function () {},
    "Microphone": function () {},
    "Modal": function () {},
    "NONE": {},
    "NOT_HAS_REQUIREMENTS": {},
    "PeerConnection": function () {},
    "PeerConnections": {
        "add": function () {},
        "remove": function () {}
    },
    "Publisher": function () {},
    "PublisherPeerConnection": function () {},
    "PublishingState": function () {},
    "Raptor": {
        "Actions": {
            "CONNECT": {},
            "CREATE": {},
            "UPDATE": {},
            "DELETE": {},
            "STATE": {},
            "FORCE_DISCONNECT": {},
            "FORCE_UNPUBLISH": {},
            "SIGNAL": {},
            "CREATE_ARCHIVE": {},
            "CLOSE_ARCHIVE": {},
            "START_RECORDING_SESSION": {},
            "STOP_RECORDING_SESSION": {},
            "START_RECORDING_STREAM": {},
            "STOP_RECORDING_STREAM": {},
            "LOAD_ARCHIVE": {},
            "START_PLAYBACK": {},
            "STOP_PLAYBACK": {},
            "APPSTATE_PUT": {},
            "APPSTATE_DELETE": {},
            "OFFER": {},
            "ANSWER": {},
            "PRANSWER": {},
            "CANDIDATE": {},
            "SUBSCRIBE": {},
            "UNSUBSCRIBE": {},
            "QUERY": {},
            "SDP_ANSWER": {},
            "PONG": {},
            "REGISTER": {},
            "QUALITY_CHANGED": {}
        },
        "Types": {
            "RPC_REQUEST": {},
            "RPC_RESPONSE": {},
            "STREAM": {},
            "ARCHIVE": {},
            "CONNECTION": {},
            "APPSTATE": {},
            "CONNECTIONCOUNT": {},
            "MODERATION": {},
            "SIGNAL": {},
            "SUBSCRIBER": {},
            "JSEP": {}
        },
        "Dispatcher": function () {},
        "serializeMessage": function () {},
        "deserializeMessage": function () {},
        "unboxFromRumorMessage": function () {},
        "parseIceServers": function () {},
        "Message": {
            "offer": function () {},
            "connections": {
                "create": function () {},
                "destroy": function () {}
            },
            "sessions": {
                "get": function () {}
            },
            "streams": {
                "get": function () {},
                "channelFromOTChannel": function () {},
                "create": function () {},
                "destroy": function () {},
                "answer": function () {},
                "candidate": function () {}
            },
            "streamChannels": {
                "update": function () {}
            },
            "subscribers": {
                "uri": function () {},
                "create": function () {},
                "destroy": function () {},
                "update": function () {},
                "candidate": function () {},
                "answer": function () {}
            },
            "subscriberChannels": {
                "update": function () {}
            },
            "signals": {
                "create": function () {}
            }
        },
        "Socket": function () {}
    },
    "Rumor": {
        "MessageType": {
            "SUBSCRIBE": {},
            "UNSUBSCRIBE": {},
            "MESSAGE": {},
            "CONNECT": {},
            "DISCONNECT": {},
            "PING": {},
            "PONG": {},
            "STATUS": {}
        },
        "PluginSocket": function () {},
        "Message": function () {},
        "NativeSocket": function () {},
        "SocketError": function () {},
        "Socket": function () {}
    },
    "Session": function () {},
    "SessionConnectEvent": function () {},
    "SessionDisconnectEvent": function () {},
    "SessionDispatcher": function () {},
    "SessionInfo": function () {},
    "Signal": function () {},
    "SignalEvent": function () {},
    "Stream": function () {},
    "StreamChannel": function () {},
    "StreamEvent": function () {},
    "StreamPropertyChangedEvent": function () {},
    "StreamUpdatedEvent": function () {},
    "StylableComponent": function () {},
    "Subscriber": function () {},
    "SubscriberPeerConnection": function () {},
    "SubscribingState": function () {},
    "VideoDimensionsChangedEvent": function () {},
    "VideoDisableWarningEvent": function () {},
    "VideoElement": function () {},
    "VideoEnabledChangedEvent": function () {},
    "VideoOrientation": {
        "ROTATED_NORMAL": {},
        "ROTATED_LEFT": {},
        "ROTATED_RIGHT": {},
        "ROTATED_UPSIDE_DOWN": {}
    },
    "WARN": {},
    "WidgetView": function () {},
    "_": {
        "getClientGuid": function () {}
    },
    "analytics": {
        "logError": function () {},
        "logEvent": function () {},
        "logQOS": function () {}
    },
    "audioContext": function () {},
    "checkScreenSharingCapability": function () {},
    "checkSystemRequirements": function () {},
    "components": function () {},
    "debug": function () {},
    "error": function () {},
    "generateSimpleStateMachine": function () {},
    "getErrorTitleByCode": function () {},
    "getLogs": {},
    "getStatsAdpater": function () {},
    "getStatsHelpers": {
        "isVideoStat": function () {},
        "isAudioStat": function () {},
        "isInboundStat": function () {},
        "parseStatCategory": function () {},
        "normalizeTimestamp": function () {}
    },
    "handleJsException": function () {},
    "httpTest": function () {},
    "info": function () {},
    "initPublisher": function () {},
    "initSession": function () {},
    "isUnloaded": function () {},
    "log": function () {},
    "onLoad": function () {},
    "onUnload": function () {},
    "overrideGuidStorage": function () {},
    "pickScreenSharingHelper": function () {},
    "properties": {
        "version": {},
        "build": {},
        "buildTime": {},
        "debug": {},
        "websiteURL": {},
        "cdnURL": {},
        "loggingURL": {},
        "apiURL": {},
        "messagingProtocol": {},
        "messagingPort": {},
        "supportSSL": {},
        "cdnURLSSL": {},
        "loggingURLSSL": {},
        "apiURLSSL": {},
        "minimumVersion": {
            "firefox": function () {},
            "chrome": function () {}
        },
        "assetURL": {},
        "cssURL": {}
    },
    "publishers": {
        "on": function () {},
        "off": function () {},
        "once": function () {},
        "dispatchEvent": function () {},
        "trigger": function () {},
        "emit": function () {},
        "addEventListener": function () {},
        "removeEventListener": function () {},
        "__testOnly": {
            "events": function () {},
            "removeAllListenersNamed": function () {},
            "removeListeners": function () {},
            "addListeners": function () {},
            "resetEventingSpies": function () {}
        },
        "reset": function () {},
        "destroy": function () {},
        "get": function () {},
        "has": function () {},
        "toString": function () {},
        "where": function () {},
        "find": function () {},
        "forEach": function () {},
        "add": function () {},
        "remove": function () {},
        "_triggerAddEvents": function () {},
        "length": function () {}
    },
    "registerScreenSharingExtension": function () {},
    "registerScreenSharingExtensionHelper": function () {},
    "reportIssue": function () {},
    "sessions": {
        "on": function () {},
        "off": function () {},
        "once": function () {},
        "dispatchEvent": function () {},
        "trigger": function () {},
        "emit": function () {},
        "addEventListener": function () {},
        "removeEventListener": function () {},
        "__testOnly": {
            "events": function () {},
            "removeAllListenersNamed": function () {},
            "removeListeners": function () {},
            "addListeners": function () {},
            "resetEventingSpies": function () {}
        },
        "reset": function () {},
        "destroy": function () {},
        "get": function () {},
        "has": function () {},
        "toString": function () {},
        "where": function () {},
        "find": function () {},
        "forEach": function () {},
        "add": function () {},
        "remove": function () {},
        "_triggerAddEvents": function () {},
        "length": function () {}
    },
    "setLogLevel": function () {},
    "shouldLog": function () {},
    "subscribers": {
        "on": function () {},
        "off": function () {},
        "once": function () {},
        "dispatchEvent": function () {},
        "trigger": function () {},
        "emit": function () {},
        "addEventListener": function () {},
        "removeEventListener": function () {},
        "__testOnly": {
            "events": function () {},
            "removeAllListenersNamed": function () {},
            "removeListeners": function () {},
            "addListeners": function () {},
            "resetEventingSpies": function () {}
        },
        "reset": function () {},
        "destroy": function () {},
        "get": function () {},
        "has": function () {},
        "toString": function () {},
        "where": function () {},
        "find": function () {},
        "forEach": function () {},
        "add": function () {},
        "remove": function () {},
        "_triggerAddEvents": function () {},
        "length": function () {}
    },
    "upgradeSystemRequirements": function () {},
    "warn": function () {},
    "webrtcTest": function () {},
    "noConflict": function () {}
};

var session = {
    on: function () {},
    publish: function () {},
    subscribe: function () {},
    connect: function() {}
};