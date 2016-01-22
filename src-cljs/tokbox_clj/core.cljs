(ns tokbox-clj.core
  (:require-macros [cljs.core.async.macros :refer [go]])
  (:require
    [reagent.core :as reagent :refer [atom]]
    [cljs-http.client :as http]
    [cljs.core.async :refer [<!]]
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

; This returns "session"


(defn tokboxInit [opentokData]

  ; session.initSession
  (def session (.OT.initSession js/window (:apiKey opentokData) (:sessionId opentokData)))
  ;(.log js/console session)
  (.log js/console opentokData)
  ; session.on('streamCreated', callback)
  (.on session "streamCreated" (fn [event]
                                 (do
                                   (.log js/console "Stream created")
                                   (.subscribe session (aget event "stream") "subscriber" (js-obj "insertMode" "append", "width" "100%", "height" "100%"))
                                   (.log js/console "Stream createdddd")
                                   )
                                 ))

  ; session.connect(sessionId, callback)
  (.connect session (:token opentokData) (fn [error]
                                               (if-not error
                                                 (do
                                                   (.log js/console "Connected without errors")
                                                   (def publisher (.OT.initPublisher js/window "publisher" (js-obj "insertMode" "append", "width" "100%", "height" "100%")))
                                                   (.publish session publisher))
                                                 (.log js/console "There was an error connecting to the session: error.code/error.message"))))
  ; session.on('sessionDisconnected', callback)
  (.on session "sessionDisconnected" (fn [event]
                                   (.log js/console "You were disconnected from the session (event.reason")))

)

; Ajax request to get a session
(go (let [response (<! (http/get "https://opentoksvr.herokuapp.com/session" {:with-credentials? false}))]
      (println "Llego el ajax")
      (tokboxInit  (:body response))))

; Home template
(defn home-page []
  [:div.container
   [:div.videobox [:div "Publisher"] [:div#publisher]]
   [:div.videobox [:div "Subscriber"] [:div#subscriber]]])

; Rendering html
(reagent/render home-page (.getElementById js/document "app"))
