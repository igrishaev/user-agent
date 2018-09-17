(ns ua-test
  (:require [clojure.test :refer :all]
            ua))


(def ua-sample
  "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like
Gecko) Chrome/67.0.3396.99 Safari/537.36")


(deftest test-real-header
  (is (= (ua/parse ua-sample)
         {:producer "Google Inc."
          :family :CHROME
          :name "Chrome"
          :type :BROWSER
          :icon "chrome.png"
          :producer-url "http://www.google.com/"
          :url "http://www.google.com/chrome"
          :device {:category :PERSONAL_COMPUTER
                   :name "Personal computer"}
          :os
          {:family :OS_X
           :family-name "OS X"
           :name "OS X"
           :producer "Apple Computer, Inc."
           :producer-url "http://www.apple.com/"
           :url "http://en.wikipedia.org/wiki/Mac_OS_X"
           :version
           {:bug-fix "6"
            :extension ""
            :groups ["10" "11" "6"]
            :major "10"
            :minor "11"
            :version "10.11.6"}}
          :type-name "Browser"
          :version
          {:bug-fix "3396"
           :extension ""
           :groups ["67" "0" "3396" "99"]
           :major "67"
           :minor "0"
           :version "67.0.3396.99"}})))
