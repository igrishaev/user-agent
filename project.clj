(defproject user-agent "0.1.1-SNAPSHOT"

  :description
  "User-Agent parser"

  :url
  "https://github.com/igrishaev/user-agent"

  :deploy-repositories
  {"releases" {:url "https://repo.clojars.org" :creds :gpg}}

  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :release-tasks
  [["vcs" "assert-committed"]
   ["test"]
   ["change" "version" "leiningen.release/bump-version" "release"]
   ["vcs" "commit"]
   ["vcs" "tag" "--no-sign"]
   ["deploy"]
   ["change" "version" "leiningen.release/bump-version"]
   ["vcs" "commit"]
   ["vcs" "push"]]

  :dependencies
  [[net.sf.uadetector/uadetector-core "0.9.22"]
   [net.sf.uadetector/uadetector-resources "2014.10"]]

  :profiles
  {:dev
   {:dependencies [[org.clojure/clojure "1.9.0"]]}})
