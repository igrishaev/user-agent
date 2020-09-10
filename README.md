
# User-Agent parser for Clojure

[uadetector]: http://uadetector.sourceforge.net/

A small, single-function library to fetch as much information from a User-Agent
HTTP header as possible. Built on top of the proven [UA Detector][uadetector]
Java package.

## Installation

Add it into your dependencies vector:

```clojure
[user-agent "0.1.0"]
```

## Usage

```clojure

(ns some.ns
  (:require [user-agent :as ua]))

(def ua-sample
  "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36")

(ua/parse ua-sample)

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
  :version "67.0.3396.99"}}
```

## License

Copyright © 2018 Ivan Grishaev

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
