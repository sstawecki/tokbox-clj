(ns tokbox-clj.core
  (:require
    [reagent.core :as reagent :refer [atom]]
    ;[reagent.session :as session]
    ;[secretary.core :as secretary :include-macros true]
    ;[goog.events :as events]
    ;[goog.history.EventType :as HistoryEventType]
    ;[markdown.core :refer [md->html]]
    ;[ajax.core :refer [GET POST]]
  )
  ;(:import goog.History)
  )

; To enable println's as console.log or something like that
(enable-console-print!)


(defonce tokboxData
         (atom {:apiKey "45460942",
                :token "1_MX40NTQ2MDk0Mn5-MTQ1MzM4OTgyODI1MH5rY2lkTXl0UVY0UVk3RmhZTnNWSEgyZUd-fg",
                :sessionId "T1==cGFydG5lcl9pZD00NTQ2MDk0MiZzaWc9ZmM3NDU5NTY4MDgxNWE4YTI0Mzk0MjVjOWFjYzEyNTEwYTBiMzY1MDpzZXNzaW9uX2lkPTFfTVg0ME5UUTJNRGswTW41LU1UUTFNek00T1RneU9ESTFNSDVyWTJsa1RYbDBVVlkwVVZrM1JtaFpUbk5XU0VneVpVZC1mZyZjcmVhdGVfdGltZT0xNDUzMzg5ODI4JnJvbGU9cHVibGlzaGVyJm5vbmNlPTE0NTMzODk4MjguMjc1Mzc3NjQ2ODQwMA=="}))

; session.initSession
(def session (.OT.initSession js/window (:apiKey @tokboxData) (:token @tokboxData)))

; session.on('streamCreated', callback)
(.on session "streamCreated" (fn [event]
                               (do
                                 (.log js/console "Stream created")
                                 (.subscribe session (aget event "stream") "subscriber" (js-obj "insertMode" "append", "width" "100%", "height" "100%")))
                               ))

; session.connect(sessionId, callback)
(.connect session (:sessionId @tokboxData) (fn [error]
                                             (if-not error
                                               (do
                                                 (.log js/console "Connected without errors")
                                                 (def publisher (.OT.initPublisher js/window "publisher" (js-obj "insertMode" "append", "width" "100%", "height" "100%")))
                                                 (.publish session publisher))
                                               (.log js/console "There was an error connecting to the session: error.code/error.message"))))

; session.on('sessionDisconnected', callback)
(.on session "sessionDisconnected" (fn [event]
                                 (.log js/console "You were disconnected from the session (event.reason")))


; Home template
(defn home-page []
  [:div.container
   [:div.videobox [:div "Publisher"] [:div#publisher]]
   [:div.videobox [:div "Subscriber"] [:div#subscriber]]])

; Rendering html
(reagent/render home-page (.getElementById js/document "app"))
