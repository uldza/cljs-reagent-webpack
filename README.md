# ClojureScript's Reagent + Webpack + NPM

## Setup

1. Include deps from CLJSJS to provide externs
2. Include NPM deps
3. Alias CLJSJS deps with empty namespaces, so those deps could be pulled from NPM instead of CLJSJS
4. Configure Webpack with CLojureScript output bundle as an entry point

## Production Build

1. Build ClojureScript `lein cljsbuild once min`
2. Bundle with deps `webpack -p`

## Development

1. Create JavaScript entry file and configure Webpack to consume it in development
2. Import required NPM deps in the entry file as well as ClojureScript output bundle file
3. Export NPM deps into global scope `window` (required to consume JS libraries from ClojureScript in development)
4. Run ClojureScript build in watch mode `rlwrap lein figwheel dev`
5. Run Webpack in watch mode `webpack -w`
