import React from 'react';
import ReactDOM from 'react-dom';
import ReactDOMServer from 'react-dom/server';
import createReactClass from 'create-react-class';

import './resources/public/js/compiled/app';

window.React = React;
window.ReactDOM = ReactDOM;
window.ReactDOMServer = ReactDOMServer;
window.createReactClass = createReactClass;
