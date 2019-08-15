# Deprecated

Ktlint ships with the import ordering rule enabled by default in the standard rule set now. It also has the ability to disable specific rules making it possible to enable specific experimental rules.

# Ktlint Rules

A set of ktlint rules:
- ktlint's experimental import ordering rule
- ktlint's disabled no wildcard imports rule
- ktlint's disabled package name rule

## Download

Add a Gradle dependency:

```groovy
ktlint "com.pinterest.ktlint:ktlint:0.33.0"
ktlint "com.gabrielittner.ktlint:ktlint-rules:0.3.0"
```

Snapshots of the development version are available in [Sonatype's `snapshots` repository][snap].

## License

```
Copyright 2018 Gabriel Ittner.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```



 [snap]: https://oss.sonatype.org/content/repositories/snapshots/
