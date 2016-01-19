(ns tokbox-clj.config
  (:require [selmer.parser :as parser]
            [clojure.tools.logging :as log]
            [tokbox-clj.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[tokbox-clj started successfully using the development profile]=-"))
   :middleware wrap-dev})
