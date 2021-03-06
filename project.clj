(defproject user-agent "0.1.0"

  :description "User-Agent parser"
  :url "https://github.com/igrishaev/user-agent"

  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies
  [[net.sf.uadetector/uadetector-core "0.9.10"]
   [net.sf.uadetector/uadetector-resources "2014.10"]]

  :profiles
  {:dev
   {:dependencies [[org.clojure/clojure "1.9.0"]]}})
