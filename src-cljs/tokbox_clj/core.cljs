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

; currently unused
(defonce tokboxData
         (atom {:apiKey "45460942",
                :token "2_MX40NTQ2MDk0Mn5-MTQ1MzMxMzUyNzEwMH5IZStzKytUSnljNzBjSkMwUU51V0dBcDl-fg",
                :sessionId "T1==cGFydG5lcl9pZD00NTQ2MDk0MiZzaWc9MGMzMzU4MTlhNjJmMTNhN2Q1Yjk4NTlhMWNlYWI5ZDJkNDBmNGFiMDpzZXNzaW9uX2lkPTJfTVg0ME5UUTJNRGswTW41LU1UUTFNek14TXpVeU56RXdNSDVJWlN0ekt5dFVTbmxqTnpCalNrTXdVVTUxVjBkQmNEbC1mZyZjcmVhdGVfdGltZT0xNDUzMzE0Mzc4JnJvbGU9cHVibGlzaGVyJm5vbmNlPTE0NTMzMTQzNzguNjMzMjE3OTU4MTY0MjQ="}))

(def session (.OT.initSession js/window (:apiKey @tokboxData) (:token @tokboxData)))

(.on session "screamCreated" (defn onStreamCreated [event]
                               (.alert js/window "asd")
                               (.alert js/window "asd2")
                               (println "asd ")))

(.log js/console session)


;(js* "  session.on('streamCreated', function(event) { session.subscribe(event.stream, 'subscriber', { insertMode: 'append', width: '100%', height: '100%' }); });")

;(js* "  session.on('sessionDisconnected', function(event) {  console.log('You were disconnected from the session.', event.reason); });")


(.connect session (:sessionId @tokboxData) (defn onConnect [error] (.log js/console "increible!"))) 

;(js* "  session.connect('T1==cGFydG5lcl9pZD00NTQ2MDk0MiZzaWc9ZGJmNzgxNzc0NjVkZjQ5YmJlMDRkODVjYzE3YjZkYjY5MjlkNWYyMDpzZXNzaW9uX2lkPTJfTVg0ME5UUTJNRGswTW41LU1UUTFNekl5TmprMU1qSTRPWDVwTlZSeFdTc3JhVkV4TjNrelVFMUJlRFZGS3pGUGVYSi1mZyZjcmVhdGVfdGltZT0xNDUzMjI3MDU2JnJvbGU9cHVibGlzaGVyJm5vbmNlPTE0NTMyMjcwNTYuODUwNDcxNjIwNzExOQ==', function(error) { if (!error) { var publisher = OT.initPublisher('publisher', { insertMode: 'append', width: '100%', height: '100%' }); session.publish(publisher); } else { console.log('There was an error connecting to the session: ', error.code, error.message); }});")


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
