(ns ^:figwheel-no-load tokbox-clj.app
  (:require [tokbox-clj.core :as core]
            [figwheel.client :as figwheel :include-macros true]))

(enable-console-print!)

(figwheel/watch-and-reload
  :websocket-url "ws://localhost:3449/figwheel-ws")

;(core/init!)
