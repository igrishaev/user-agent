(ns user-agent
  (:require [clojure.string :as str])
  (:import [net.sf.uadetector.service UADetectorServiceFactory]

           [net.sf.uadetector
            UserAgent
            VersionNumber
            OperatingSystem
            DeviceCategory
            UserAgentStringParser]))

(def ^:private parser
  (UADetectorServiceFactory/getResourceModuleParser))

(defprotocol ToClojure
  (->clj [x]))

(defn parse [^String user-agent]
  (->clj (.parse ^UserAgentStringParser parser user-agent)))

(extend-protocol ToClojure

  UserAgent
  (->clj [ua]
    {:device       (->clj (.getDeviceCategory ua))
     :family       (->clj (.getFamily ua))
     :icon         (.getIcon ua)
     :name         (.getName ua)
     :os           (->clj (.getOperatingSystem ua))
     :producer     (.getProducer ua)
     :producer-url (.getProducerUrl ua)
     :type         (->clj (.getType ua))
     :type-name    (.getTypeName ua)
     :url          (.getUrl ua)
     :version      (->clj (.getVersionNumber ua))})

  OperatingSystem
  (->clj [os]
    {:family       (->clj (.getFamily os))
     :family-name  (.getFamilyName os)
     :name         (.getName os)
     :producer     (.getProducer os)
     :producer-url (.getProducerUrl os)
     :url          (.getUrl os)
     :version      (->clj (.getVersionNumber os))})

  DeviceCategory
  (->clj [dev]
    {:category (->clj (.getCategory dev))
     :name (.getName dev)})

  VersionNumber
  (->clj [ver]
    {:bug-fix   (.getBugfix ver)
     :extension (.getExtension ver)
     :groups    (.getGroups ver)
     :major     (.getMajor ver)
     :minor     (.getMinor ver)
     :version   (.toVersionString ver)})

  java.lang.Enum
  (->clj [e]
    (-> e .name keyword)))
