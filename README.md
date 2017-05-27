# ClojureScript's Reagent + Webpack + NPM

## Setup

1. Include deps from CLJSJS to provide externs
2. Include NPM deps
3. Alias CLJSJS deps with empty namespaces
4. Configure Webpack with Closure output bundle as an entry point

## Production Build

1. Build ClojureScript `lein cljsbuild once min`
2. Bundle with deps `webpack -p`

## Development

1. Set `:optimizations :none` in compiler options
2. Run ClojureScript build in watch mode `rlwrap lein cljsbuild auto dev`
3. Run Webpack in watch mode `webpack -w`

## Issues

Doesn't work during development.

- When built with `:optimizations :none` Webpack can not see Reagent's `require`s, because they are located in different Closure modules, which are loaded asynchronously. This emits `no js/React found` error
- For some reason doesn't work with `:optimizations :whitespace` as well
