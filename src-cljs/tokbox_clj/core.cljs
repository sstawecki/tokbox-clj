(ns tokbox-clj.core
  (:require [reagent.core :as reagent :refer [atom]]
            [reagent.session :as session]
            [secretary.core :as secretary :include-macros true]
            [goog.events :as events]
            [goog.history.EventType :as HistoryEventType]
            [markdown.core :refer [md->html]]
            [ajax.core :refer [GET POST]])
  (:import goog.History))

(defn nav-link [uri title page collapsed?]
  [:li {:class (when (= page (session/get :page)) "active")}
   [:a {:href uri
        :on-click #(reset! collapsed? true)}
    title]])

(defn navbar []
  (let [collapsed? (atom true)]
    (fn []
      [:nav.navbar.navbar-inverse.navbar-fixed-top
       [:div.container
        [:div.navbar-header
         [:button.navbar-toggle
          {:class         (when-not @collapsed? "collapsed")
           :data-toggle   "collapse"
           :aria-expanded @collapsed?
           :aria-controls "navbar"
           :on-click      #(swap! collapsed? not)}
          [:span.sr-only "Toggle Navigation"]
          [:span.icon-bar]
          [:span.icon-bar]
          [:span.icon-bar]]
         [:a.navbar-brand {:href "#/"} "tokbox-clj"]]
        [:div.navbar-collapse.collapse
         (when-not @collapsed? {:class "in"})
         [:ul.nav.navbar-nav
          [nav-link "#/" "Home" :home collapsed?]
          [nav-link "#/about" "About" :about collapsed?]]]]])))

(defn about-page []
  [:div.container
   [:div.row
    [:div.col-md-12
     "this is the story of tokbox-clj... work in progress"]]])


;============= My spot...


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



(defn home-page []
  [:div.container
   [:div.videobox [:div "Publisher"] [:div#publisher]]
   [:div.videobox [:div "Subscriber"] [:div#subscriber]]])


;============= end of my spot...

(def pages
  {:home #'home-page
   :about #'about-page})

(defn page []
  [(pages (session/get :page))])

;; -------------------------
;; Routes
(secretary/set-config! :prefix "#")

(secretary/defroute "/" []
  (session/put! :page :home))

(secretary/defroute "/about" []
  (session/put! :page :about))

;; -------------------------
;; History
;; must be called after routes have been defined
(defn hook-browser-navigation! []
  (doto (History.)
        (events/listen
          HistoryEventType/NAVIGATE
          (fn [event]
              (secretary/dispatch! (.-token event))))
        (.setEnabled true)))

;; -------------------------
;; Initialize app
(defn fetch-docs! []
  (GET (str js/context "/docs") {:handler #(session/put! :docs %)}))

(defn mount-components []
  ;(reagent/render [#'navbar] (.getElementById js/document "navbar"))
  (reagent/render [#'page] (.getElementById js/document "app")))

(defn init! []
  (fetch-docs!)
  (hook-browser-navigation!)
  (mount-components))
