(defproject audiogum/aerogrant "0.1.15-SNAPSHOT"
  :description "mashup of aero and integrant with some nice addons"
  :url "https://github.com/Bigsy/aerogrant"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.11.4"]
                 [aero "1.1.6"]
                 [cheshire "5.13.0"]
                 [com.cognitect.aws/api "0.8.711"]
                 [com.cognitect.aws/sts "857.2.1574.0"]
                 [com.cognitect.aws/endpoints "1.1.12.772"]
                 [com.cognitect.aws/secretsmanager "869.2.1687.0"]
                 [integrant "0.10.0"]]

  :release-tasks [["vcs" "assert-committed"]
                  ["change" "version" "leiningen.release/bump-version" "release"]
                  ["vcs" "commit"]
                  ["vcs" "tag" "--no-sign"]
                  ["deploy" "releases"]
                  ["change" "version" "leiningen.release/bump-version" "patch"]
                  ["vcs" "commit"]
                  ["vcs" "push" "origin" "main"]]

  :plugins [[s3-wagon-private "1.3.4"]]

  :repositories {"releases" {:url           "s3p://repo.bowerswilkins.net/releases/"
                             :no-auth       true
                             :sign-releases false}}

  :repl-options {:init-ns aerogrant.core})
