(ns user-agent-test
  (:require [clojure.test :refer :all]
            [user-agent :as ua]))


(def ua-desktop
  "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like
Gecko) Chrome/67.0.3396.99 Safari/537.36")


(def ua-ipad
  "Mozilla/5.0 (iPad; CPU OS 11_0_2 like Mac OS X) AppleWebKit/604.1.38 (KHTML, like Gecko) Version/11.0 Mobile/15A421 Safari/604.1")


(def ua-google-bot
  "Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)")


(deftest test-desktop
  (is (= (ua/parse ua-desktop)
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


(deftest test-ipad
  (is (= (ua/parse ua-ipad)
         {:producer "Apple Inc."
          :family :MOBILE_SAFARI
          :name "Mobile Safari"
          :type :MOBILE_BROWSER
          :icon "safari.png"
          :producer-url "http://www.apple.com/"
          :url "http://en.wikipedia.org/wiki/Safari_%28web_browser%29"
          :device {:category :TABLET :name "Tablet"}
          :os
          {:family :IOS
           :family-name "iOS"
           :name "iOS"
           :producer "Apple Inc."
           :producer-url "http://www.apple.com/"
           :url "http://en.wikipedia.org/wiki/IOS"
           :version
           {:bug-fix "2"
            :extension ""
            :groups ["11" "0" "2"]
            :major "11"
            :minor "0"
            :version "11.0.2"}}
          :type-name "Mobile Browser"
          :version
          {:bug-fix ""
           :extension ""
           :groups ["11" "0" ""]
           :major "11"
           :minor "0"
           :version "11.0"}})))


(deftest test-google-bot
  (is (= (ua/parse ua-google-bot)
         {:producer "Google Inc."
          :family :GOOGLEBOT
          :name "Googlebot/2.1"
          :type :ROBOT
          :icon "bot_googlebot.png"
          :producer-url "http://www.google.com/"
          :url "/list-of-ua/bot-detail?bot=Googlebot"
          :device {:category :OTHER :name "Other"}
          :os
          {:family :UNKNOWN
           :family-name "unknown"
           :name "unknown"
           :producer ""
           :producer-url ""
           :url ""
           :version
           {:bug-fix ""
            :extension ""
            :groups ["" "" ""]
            :major ""
            :minor ""
            :version ""}}
          :type-name "Robot"
          :version
          {:bug-fix ""
           :extension ""
           :groups ["2" "1" ""]
           :major "2"
           :minor "1"
           :version "2.1"}})))
