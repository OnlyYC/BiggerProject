/*! http://mths.be/placeholder v2.0.7 by @mathias */
;
(function (h, j, e) {
    var a = "placeholder" in j.createElement("input");
    var f = "placeholder" in j.createElement("textarea");
    var k = e.fn;
    var d = e.valHooks;
    var b = e.propHooks;
    var m;
    var l;
    if (a && f) {
        l = k.placeholder = function () {
            return this
        };
        l.input = l.textarea = true
    } else {
        l = k.placeholder = function () {
            var n = this;
            n.filter((a ? "textarea" : ":input") + "[placeholder]").not(".placeholder").bind({
                "focus.placeholder": c,
                "blur.placeholder": g
            }).data("placeholder-enabled", true).trigger("blur.placeholder");
            return n
        };
        l.input = a;
        l.textarea = f;
        m = {
            get: function (o) {
                var n = e(o);
                var p = n.data("placeholder-password");
                if (p) {
                    return p[0].value
                }
                return n.data("placeholder-enabled") && n.hasClass("placeholder") ? "" : o.value
            }, set: function (o, q) {
                var n = e(o);
                var p = n.data("placeholder-password");
                if (p) {
                    return p[0].value = q
                }
                if (!n.data("placeholder-enabled")) {
                    return o.value = q
                }
                if (q == "") {
                    o.value = q;
                    if (o != j.activeElement) {
                        g.call(o)
                    }
                } else {
                    if (n.hasClass("placeholder")) {
                        c.call(o, true, q) || (o.value = q)
                    } else {
                        o.value = q
                    }
                }
                return n
            }
        };
        if (!a) {
            d.input = m;
            b.value = m
        }
        if (!f) {
            d.textarea = m;
            b.value = m
        }
        e(function () {
            e(j).delegate("form", "submit.placeholder", function () {
                var n = e(".placeholder", this).each(c);
                setTimeout(function () {
                    n.each(g)
                }, 10)
            })
        });
        e(h).bind("beforeunload.placeholder", function () {
            e(".placeholder").each(function () {
                this.value = ""
            })
        })
    }
    function i(o) {
        var n = {};
        var p = /^jQuery\d+$/;
        e.each(o.attributes, function (r, q) {
            if (q.specified && !p.test(q.name)) {
                n[q.name] = q.value
            }
        });
        return n
    }

    function c(o, p) {
        var n = this;
        var q = e(n);
        if (n.value == q.attr("placeholder") && q.hasClass("placeholder")) {
            if (q.data("placeholder-password")) {
                q = q.hide().next().show().attr("id", q.removeAttr("id").data("placeholder-id"));
                if (o === true) {
                    return q[0].value = p
                }
                q.focus()
            } else {
                n.value = "";
                q.removeClass("placeholder");
                n == j.activeElement && n.select()
            }
        }
    }

    function g() {
        var r;
        var n = this;
        var q = e(n);
        var p = this.id;
        if (n.value == "") {
            if (n.type == "password") {
                if (!q.data("placeholder-textinput")) {
                    try {
                        r = q.clone().attr({type: "text"})
                    } catch (o) {
                        r = e("<input>").attr(e.extend(i(this), {type: "text"}))
                    }
                    r.removeAttr("name").data({
                        "placeholder-password": q,
                        "placeholder-id": p
                    }).bind("focus.placeholder", c);
                    q.data({"placeholder-textinput": r, "placeholder-id": p}).before(r)
                }
                q = q.removeAttr("id").hide().prev().attr("id", p).show()
            }
            q.addClass("placeholder");
            q[0].value = q.attr("placeholder")
        } else {
            q.removeClass("placeholder")
        }
    }
}(this, document, jQuery));

/* Modernizr 2.6.2 (Custom Build) | MIT & BSD
 * Build: http://modernizr.com/download/#-touch-cssclasses-teststyles-prefixes
 */
;
window.Modernizr = function (a, b, c) {
    function w(a) {
        j.cssText = a
    }

    function x(a, b) {
        return w(m.join(a + ";") + (b || ""))
    }

    function y(a, b) {
        return typeof a === b
    }

    function z(a, b) {
        return !!~("" + a).indexOf(b)
    }

    function A(a, b, d) {
        for (var e in a) {
            var f = b[a[e]];
            if (f !== c)return d === !1 ? a[e] : y(f, "function") ? f.bind(d || b) : f
        }
        return !1
    }

    var d = "2.6.2", e = {}, f = !0, g = b.documentElement, h = "modernizr", i = b.createElement(h), j = i.style, k, l = {}.toString, m = " -webkit- -moz- -o- -ms- ".split(" "), n = {}, o = {}, p = {}, q = [], r = q.slice, s, t = function (a, c, d, e) {
        var f, i, j, k, l = b.createElement("div"), m = b.body, n = m || b.createElement("body");
        if (parseInt(d, 10))while (d--)j = b.createElement("div"), j.id = e ? e[d] : h + (d + 1), l.appendChild(j);
        return f = ["&#173;", '<style id="s', h, '">', a, "</style>"].join(""), l.id = h, (m ? l : n).innerHTML += f, n.appendChild(l), m || (n.style.background = "", n.style.overflow = "hidden", k = g.style.overflow, g.style.overflow = "hidden", g.appendChild(n)), i = c(l, a), m ? l.parentNode.removeChild(l) : (n.parentNode.removeChild(n), g.style.overflow = k), !!i
    }, u = {}.hasOwnProperty, v;
    !y(u, "undefined") && !y(u.call, "undefined") ? v = function (a, b) {
        return u.call(a, b)
    } : v = function (a, b) {
        return b in a && y(a.constructor.prototype[b], "undefined")
    }, Function.prototype.bind || (Function.prototype.bind = function (b) {
        var c = this;
        if (typeof c != "function")throw new TypeError;
        var d = r.call(arguments, 1), e = function () {
            if (this instanceof e) {
                var a = function () {
                };
                a.prototype = c.prototype;
                var f = new a, g = c.apply(f, d.concat(r.call(arguments)));
                return Object(g) === g ? g : f
            }
            return c.apply(b, d.concat(r.call(arguments)))
        };
        return e
    }), n.touch = function () {
        var c;
        return "ontouchstart"in a || a.DocumentTouch && b instanceof DocumentTouch ? c = !0 : t(["@media (", m.join("touch-enabled),("), h, ")", "{#modernizr{top:9px;position:absolute}}"].join(""), function (a) {
            c = a.offsetTop === 9
        }), c
    };
    for (var B in n)v(n, B) && (s = B.toLowerCase(), e[s] = n[B](), q.push((e[s] ? "" : "no-") + s));
    return e.addTest = function (a, b) {
        if (typeof a == "object")for (var d in a)v(a, d) && e.addTest(d, a[d]); else {
            a = a.toLowerCase();
            if (e[a] !== c)return e;
            b = typeof b == "function" ? b() : b, typeof f != "undefined" && f && (g.className += " " + (b ? "" : "no-") + a), e[a] = b
        }
        return e
    }, w(""), i = k = null, e._version = d, e._prefixes = m, e.testStyles = t, g.className = g.className.replace(/(^|\s)no-js(\s|$)/, "$1$2") + (f ? " js " + q.join(" ") : ""), e
}(this, this.document);
Modernizr.addTest('android', function () {
    return !!navigator.userAgent.match(/Android/i)
});
Modernizr.addTest('chrome', function () {
    return !!navigator.userAgent.match(/Chrome/i)
});
Modernizr.addTest('firefox', function () {
    return !!navigator.userAgent.match(/Firefox/i)
});
Modernizr.addTest('iemobile', function () {
    return !!navigator.userAgent.match(/IEMobile/i)
});
Modernizr.addTest('ie', function () {
    return !!navigator.userAgent.match(/MSIE/i)
});
Modernizr.addTest('ie8', function () {
    return !!navigator.userAgent.match(/MSIE 8/i)
});
Modernizr.addTest('ie10', function () {
    return !!navigator.userAgent.match(/MSIE 10/i)
});
Modernizr.addTest('ie11', function () {
    return !!navigator.userAgent.match(/Trident.*rv:11\./)
});
Modernizr.addTest('ios', function () {
    return !!navigator.userAgent.match(/iPhone|iPad|iPod/i)
});
Modernizr.addTest('ios7 ipad', function () {
    return !!navigator.userAgent.match(/iPad;.*CPU.*OS 7_\d/i)
});
/*!
 * screenfull
 * v1.0.4 - 2013-05-26
 * https://github.com/sindresorhus/screenfull.js
 * (c) Sindre Sorhus; MIT License
 */
(function (a, b) {
    "use strict";
    var c = "undefined" != typeof Element && "ALLOW_KEYBOARD_INPUT"in Element, d = function () {
        for (var a, c, d = [["requestFullscreen", "exitFullscreen", "fullscreenElement", "fullscreenEnabled", "fullscreenchange", "fullscreenerror"], ["webkitRequestFullscreen", "webkitExitFullscreen", "webkitFullscreenElement", "webkitFullscreenEnabled", "webkitfullscreenchange", "webkitfullscreenerror"], ["webkitRequestFullScreen", "webkitCancelFullScreen", "webkitCurrentFullScreenElement", "webkitCancelFullScreen", "webkitfullscreenchange", "webkitfullscreenerror"], ["mozRequestFullScreen", "mozCancelFullScreen", "mozFullScreenElement", "mozFullScreenEnabled", "mozfullscreenchange", "mozfullscreenerror"]], e = 0, f = d.length, g = {}; f > e; e++)if (a = d[e], a && a[1]in b) {
            for (e = 0, c = a.length; c > e; e++)g[d[0][e]] = a[e];
            return g
        }
        return !1
    }(), e = {
        request: function (a) {
            var e = d.requestFullscreen;
            a = a || b.documentElement, /5\.1[\.\d]* Safari/.test(navigator.userAgent) ? a[e]() : a[e](c && Element.ALLOW_KEYBOARD_INPUT)
        }, exit: function () {
            b[d.exitFullscreen]()
        }, toggle: function (a) {
            this.isFullscreen ? this.exit() : this.request(a)
        }, onchange: function () {
        }, onerror: function () {
        }, raw: d
    };
    return d ? (Object.defineProperties(e, {
        isFullscreen: {
            get: function () {
                return !!b[d.fullscreenElement]
            }
        }, element: {
            enumerable: !0, get: function () {
                return b[d.fullscreenElement]
            }
        }, enabled: {
            enumerable: !0, get: function () {
                return !!b[d.fullscreenEnabled]
            }
        }
    }), b.addEventListener(d.fullscreenchange, function (a) {
        e.onchange.call(e, a)
    }), b.addEventListener(d.fullscreenerror, function (a) {
        e.onerror.call(e, a)
    }), a.screenfull = e, void 0) : a.screenfull = !1
})(window, document);


// data-shift api 
+function ($) {
    "use strict";

    /* SHIFT CLASS DEFINITION
     * ====================== */

    var Shift = function (element) {
        this.$element = $(element)
        this.$prev = this.$element.prev()
        !this.$prev.length && (this.$parent = this.$element.parent())
    }

    Shift.prototype = {
        constructor: Shift

        , init: function () {
            var $el = this.$element
                , method = $el.data()['toggle'].split(':')[1]
                , $target = $el.data('target')
            $el.hasClass('in') || $el[method]($target).addClass('in')
        }
        , reset: function () {
            this.$parent && this.$parent['prepend'](this.$element)
            !this.$parent && this.$element['insertAfter'](this.$prev)
            this.$element.removeClass('in')
        }
    }

    /* SHIFT PLUGIN DEFINITION
     * ======================= */

    $.fn.shift = function (option) {
        return this.each(function () {
            var $this = $(this)
                , data = $this.data('shift')
            if (!data) $this.data('shift', (data = new Shift(this)))
            if (typeof option == 'string') data[option]()
        })
    }

    $.fn.shift.Constructor = Shift
}(jQuery);


// data-bjax api 
+function ($) {
    "use strict";
    var Bjax = function (options) {
        this.options = options;
        this.$element = $(this.options.target || 'html');
        this.start()
    };

    Bjax.DEFAULTS = {
        backdrop: true,
        url: '',
        replace:true,
        target:'#parContainer',
        el:'#content',
        pushState:true,
        parameter:{}
    };

    Bjax.prototype.start = function () {
        var that = this;
        this.backdrop();
        $.ajax({
            url:this.options.url,
            data:this.options.parameters
        }
        ).done(function (r) {
            that.$content = r;
            //先根据返回的信息，是到目标页面还是给出提示信息
            if(typeof(r.flag) != "undefined"&&!r.flag){
                that.$backdrop.remove();
                Base.processData(r,function(data){

                },null,function(data){
                    console.info("fail");
                    Alert.error(data.message);
                });
            }else{
                that.complete();
            }

        });
    };

    Bjax.prototype.complete = function () {
        var that = this;
        //是否加入浏览器历史
        if(that.options.pushState){
            if (this.$element.is('html') || (this.options.replace)) {
                try {
                    var json={time:new Date().getTime()};
                    window.history.pushState(json, '', this.options.url);
                } catch (e) {
                    window.location.replace(this.options.url)
                }
            }
        }
        this.updateBar(100);
    };

    Bjax.prototype.backdrop = function () {
        this.$element.css('position', 'relative')
        this.$backdrop = $('<div class="backdrop fade bg-white"></div>')
            .appendTo(this.$element);
        if (!this.options.backdrop) this.$backdrop.css('height', '2');
        this.$backdrop[0].offsetWidth; // force reflow
        this.$backdrop.addClass('in');

        this.$bar = $('<div class="bar b-t b-2x b-info"></div>')
            .width(0)
            .appendTo(this.$backdrop);
    };

    Bjax.prototype.update = function () {
        this.$element.css('position', '');
        if (!this.$element.is('html')) {
            if (this.options.el) {
                this.$content = $(this.$content).find(this.options.el);
            }
            this.$element.html(this.$content);
        }
        if (this.$element.is('html')) {
            if ($('.ie').length) {
                location.reload();
                return;
            }
            document.open();
            document.write(this.$content);
            document.close();
        }

        //执行init
        init();
    };

    Bjax.prototype.updateBar = function (per) {
        var that = this;
        this.$bar.stop().animate({
            width: per + '%'
        }, 500, 'linear', function () {
            if (per == 100) that.update();
        });


    };

    Bjax.prototype.enable = function (e) {

        return true;
    };

    $.fn.bjax = function (option) {
        return this.each(function () {
            var $this = $(this);
            var options = $.extend({}, Bjax.DEFAULTS, $this.data(), typeof option == 'object' && option)
            new Bjax(options);
        })
    };

    $.fn.bjax.Constructor = Bjax;

    $(window).on("popstate", function (e) {
        console.info(window.location.href);
        var url=window.location.href;
        var options = $.extend({}, Bjax.DEFAULTS, {pushState: false,url:url});
        new Bjax(options);
        e.preventDefault();
        //if (e.originalEvent.state !== null) {
        //    console.info(window.location.href);
        //    var url=window.location.href;
        //    var options = $.extend({}, Bjax.DEFAULTS, {pushState: false,url:url});
        //    new Bjax(options);
        //    //  window.location.reload(true);
        //    e.preventDefault();
        //}

    });

    $(document).delegate('[data-bjax]','click', function (e) {
        if (!Bjax.prototype.enable(e)) return;
        $(this).bjax({url: baseUrl+$(this).attr('href') || $(this).attr('data-url')});
        e.preventDefault();
    })
}(jQuery);




Date.now = Date.now || function () {
        return +new Date;
    };

+function ($) {

    $(function () {

        // toogle fullscreen
        $(document).on('click', "[data-toggle=fullscreen]", function (e) {
            e.preventDefault();
            if (screenfull.enabled) {
                screenfull.request();
            }
        });

        // placeholder
        $('input[placeholder], textarea[placeholder]').placeholder();

        // popover
        $("[data-toggle=popover]").popover();
        $(document).on('click', '.popover-title .close', function (e) {
            var $target = $(e.target), $popover = $target.closest('.popover').prev();
            $popover && $popover.popover('hide');
        });

        // ajax modal
        $(document).on('click', '[data-toggle="ajaxModal"]',
            function (e) {
                $('#ajaxModal').remove();
                e.preventDefault();
                var $this = $(this)
                    , $remote = $this.data('remote') || $this.attr('href')
                    , $modal = $('<div class="modal fade" id="ajaxModal"><div class="modal-body"></div></div>');
                $('body').append($modal);
                $modal.modal();
                $modal.load($remote);
            }
        );

        // dropdown menu
        $.fn.dropdown.Constructor.prototype.change = function (e) {
            e.preventDefault();
            var $item = $(e.target), $select, $checked = false, $menu, $label;
            !$item.is('a') && ($item = $item.closest('a'));
            $menu = $item.closest('.dropdown-menu');
            $label = $menu.parent().find('.dropdown-label');
            $labelHolder = $label.text();
            $select = $item.parent().find('input');
            $checked = $select.is(':checked');
            if ($select.is(':disabled')) return;
            if ($select.attr('type') == 'radio' && $checked) return;
            if ($select.attr('type') == 'radio') $menu.find('li').removeClass('active');
            $item.parent().removeClass('active');
            !$checked && $item.parent().addClass('active');
            $select.prop("checked", !$select.prop("checked"));

            $items = $menu.find('li > input:checked');
            if ($items.length) {
                $text = [];
                $items.each(function () {
                    var $str = $(this).parent().text();
                    $str && $text.push($.trim($str));
                });

                $text = $text.length < 4 ? $text.join(', ') : $text.length + ' selected';
                $label.html($text);
            } else {
                $label.html($label.data('placeholder'));
            }
        }
        $(document).on('click.dropdown-menu', '.dropdown-select > li > a', $.fn.dropdown.Constructor.prototype.change);

        // tooltip
        $("[data-toggle=tooltip]").tooltip();

        // class
        $(document).on('click', '[data-toggle^="class"]', function (e) {
            e && e.preventDefault();
            var $this = $(e.target), $class, $target, $tmp, $classes, $targets;
            !$this.data('toggle') && ($this = $this.closest('[data-toggle^="class"]'));
            $class = $this.data()['toggle'];
            $target = $this.data('target') || $this.attr('href');
            $class && ($tmp = $class.split(':')[1]) && ($classes = $tmp.split(','));
            $target && ($targets = $target.split(','));
            $classes && $classes.length && $.each($targets, function (index, value) {
                if ($classes[index].indexOf('*') !== -1) {
                    var patt = new RegExp('\\s' +
                        $classes[index].
                            replace(/\*/g, '[A-Za-z0-9-_]+').
                            split(' ').
                            join('\\s|\\s') +
                        '\\s', 'g');
                    $($this).each(function (i, it) {
                        var cn = ' ' + it.className + ' ';
                        while (patt.test(cn)) {
                            cn = cn.replace(patt, ' ');
                        }
                        it.className = $.trim(cn);
                    });
                }
                ($targets[index] != '#') && $($targets[index]).toggleClass($classes[index]) || $this.toggleClass($classes[index]);
            });
            $this.toggleClass('active');
        });

        // panel toggle
        $(document).on('click', '.panel-toggle', function (e) {
            e && e.preventDefault();
            var $this = $(e.target), $class = 'collapse', $target;
            if (!$this.is('a')) $this = $this.closest('a');
            $target = $this.closest('.panel');
            $target.find('.panel-body').toggleClass($class);
            $this.toggleClass('active');
        });

        // carousel
        $('.carousel.auto').carousel();

        // button loading
        $(document).on('click.button.data-api', '[data-loading-text]', function (e) {
            var $this = $(e.target);
            $this.is('i') && ($this = $this.parent());
            $this.button('loading');
        });

        var $window = $(window);
        // mobile
        var mobile = function (option) {
            if (option == 'reset') {
                $('[data-toggle^="shift"]').shift('reset');
                return true;
            }
            $('[data-toggle^="shift"]').shift('init');
            return true;
        };
        // unmobile
        $window.width() < 768 && mobile();
        // resize
        var $resize, $width = $window.width();
        $window.resize(function () {
            if ($width !== $window.width()) {
                clearTimeout($resize);
                $resize = setTimeout(function () {
                    setHeight();
                    $window.width() < 768 && mobile();
                    $window.width() >= 768 && mobile('reset') && fixVbox();
                    $width = $window.width();
                }, 500);
            }
        });

        // fluid layout
        var setHeight = function () {
            $('.app-fluid #nav > *').css('min-height', $(window).height() - 60);
            return true;
        }
        setHeight();


        // fix vbox
        var fixVbox = function () {
            $('.ie11 .vbox').each(function () {
                $(this).height($(this).parent().height());
            });
            return true;
        }
        fixVbox();

        // collapse nav
        $(document).on('click', '[data-ride="collapse"] a', function (e) {
            var $this = $(e.target), $active;
            $this.is('a') || ($this = $this.closest('a'));

            $active = $this.parent().siblings(".active");
            $active && $active.toggleClass('active').find('> ul:visible').slideUp(200);

            ($this.parent().hasClass('active') && $this.next().slideUp(200)) || $this.next().slideDown(200);
            $this.parent().toggleClass('active');

            $this.next().is('ul') && e.preventDefault();

            setTimeout(function () {
                $(document).trigger('updateNav');
            }, 300);
        });

        // dropdown still
        $(document).on('click.bs.dropdown.data-api', '.dropdown .on, .dropup .on, .open .on', function (e) {
            e.stopPropagation()
        });

    });
}(jQuery);



//toggle
+function ($) {
    'use strict';

    // BUTTON PUBLIC CLASS DEFINITION
    // ==============================

    var MyToggle = function (element) {
        this.$element  = $(element)
        this.isLoading = false
    }

    MyToggle.DEFAULTS = {
        loadingText: 'loading...'
    }



    MyToggle.prototype.toggle = function () {
        var changed = true
        var $parent = this.$element.closest('[data-toggle="toggle"]')

        if ($parent.length) {
            $parent.toggleClass("active");

            var text=this.$element.find("text");
            var text_active=this.$element.find("text-active");
            text.toggleClass("text").toggleClass("text-active");
            text_active.toggleClass("text").toggleClass("text-active");

        }


    }


    // BUTTON PLUGIN DEFINITION
    // ========================


    $.fn.myToggle = function (option) {
        return this.each(function () {
            var $this   = $(this)

            var data = new MyToggle($this)

            if (option == 'toggle') data.toggle()
        })
    }

    $.fn.myToggle.Constructor = MyToggle





    //  DATA-API
    // ===============

    $(document).delegate('[data-toggle=toggle]', 'click', function (e) {
        var $toggle = $(e.target)

        $toggle.myToggle('toggle')
        e.preventDefault()
    })

}(jQuery);


//MyShow
+function ($) {
    'use strict';

    // MyShow
    // ==============================

    var MyShow = function (element,options) {
        this.options=options;
        this.$element  = $(element);
        this.target=$(this.options.target);
    };

    MyShow.DEFAULTS = {

    };



    MyShow.prototype.toggle = function () {
        var $parent = this.$element.closest('[data-toggle="show"]')

        if ($parent.length) {

            var $target=$(this.target);
            if($target.length){
                $target.toggleClass('hidden');
            }
        }


    }
    MyShow.prototype.hidden = function () {
        var $parent = this.$element.closest('[data-toggle="show"]')

        if ($parent.length) {

            var $target=$(this.target);
            if($target.length){
                $target.addClass('hidden');
            }
        }


    }
    MyShow.prototype.show = function () {
        var $parent = this.$element.closest('[data-toggle="show"]')

        if ($parent.length) {

            var $target=$(this.target);
            if($target.length){
                $target.removeClass('hidden');
            }
        }


    }


    // Show PLUGIN DEFINITION
    // ========================


    $.fn.myshow = function (str) {
        return this.each(function () {
            var $this   = $(this)
            var options=$.extend({}, MyShow.DEFAULTS, $this.data());

            var data = new MyShow($this,options);
            if(str){
                data.hidden();
            }else{
                data.toggle();
            }


        })
    }

    $.fn.myshow.Constructor = MyShow






    //  DATA-API
    // ===============

    $(document).delegate('[data-toggle=show]', 'click', function (e) {
        var $show = $(e.target);
       $("[data-toggle=show]").myshow(true);
        $show.myshow();
        e.preventDefault()
    })

}(jQuery);




//隐藏显示
+function ($) {
    'use strict';

    var HideAndShow = function (element, options) {
            this.init(element, options);
        },
        old = null;


    HideAndShow.prototype ={
        init:function(element, options){
            //初始化
            //设置参数
            this.$element = $(element);
            this.options = $.extend({}, (this.options || $.fn.hideAndShow.defaults), options);





        },
        toggle:function(){
            var that=this;
            //除自己之外的全部隐藏
            this.all.each(function(index, item){
                var $this = $(item),data = $this.data('hideAndShow');
                if(data===that){
                    //
                    console.info('自己人');

                }else{
                    $(data.options.target).slideUp();
                }


            });


            //自己的隐藏显示
            $(this.options.target).slideToggle();

            //如果是第一调用toggle，调用firstClickCall
            if(!this.isfirst){
                this.options.firstClickCall(this.options.target,this.options.param);
                this.isfirst=1;
            }
        }

    };


    old = $.fn.hideAndShow;

    $.fn.hideAndShow = function (option) {

        var args = arguments,
            result = null,all=$(this);


        $(this).each(function (index, item) {
            console.info($(item).data());
            var $this = $(item),
                data = $this.data('hideAndShow'),
                options = (typeof option !== 'object') ? null : option;
                options=$.extend({},options,$(item).data());


            //点击事件
            $this.click(function(){
                data.toggle();
            });

            if (!data) {
                data = new HideAndShow(this, options);
                data.all=all;

                $this = $(data.$element);

                $this.data('hideAndShow', data);

                return;
            }


            if (typeof option === 'string') {

                if (data[option]) {
                    result = data[option].apply(data, Array.prototype.slice.call(args, 1));
                } else {
                    throw "Method " + option + " does not exist";
                }

            }
        });

        return result;

    };

    //
    $.fn.hideAndShow.defaults={


        firstClickCall:function(target,param){

        }
    };
    $.fn.hideAndShow.Constructor = HideAndShow;


}(jQuery);




//
+function ($) {
    'use strict';
    var MySwitch = function (element, options) {
            this.init(element, options);
        },
        old = null;
    MySwitch.prototype ={
        init:function(element, options){
            this.$element = $(element);
            //初始化参数
            this.options = $.extend({}, (this.options || $.fn.mySwitch.defaults), options);

            var that=this;
            this.$element.find(this.options.childFilter).click(function(){
                //所有的移除class
                that.$element.find(that.options.childFilter).not(this).removeClass(that.options.addCl);
                //当前元素添加class
                $(this).addClass(that.options.addCl);
                //回调
                that.options.callback($(this));
            });

        }
    }
    old = $.fn.mySwitch;


    $.fn.mySwitch = function (option) {

        var args = arguments,
            result = null;

        $(this).each(function (index, item) {
            var $this = $(item),
                data = $this.data('mySwitch'),
                options = (typeof option !== 'object') ? null : option;

            if (!data) {
                data = new MySwitch(this, options);

                $this = $(data.$element);

                $this.data('mySwitch', data);

                return;
            }

            if (typeof option === 'string') {

                if (data[option]) {
                    result = data[option].apply(data, Array.prototype.slice.call(args, 1));
                } else {
                    throw "Method " + option + " does not exist";
                }

            }
        });

        return result;

    };
    //默认值
    $.fn.mySwitch.defaults={
        childFilter:'.myswitch',
        addCl:'text-info',
        //每个子元素点击时的回调方法
        callback:function(el){

        }
    };
    $.fn.mySwitch.Constructor = MySwitch;

}(jQuery);


//序列化表单为对象
(function($){
    $.fn.serializeJson=function(){
        var serializeObj={};
        var array=this.serializeArray();
        var str=this.serialize();
        $(array).each(function(){
            if(serializeObj[this.name]){
                if($.isArray(serializeObj[this.name])){
                    serializeObj[this.name].push(this.value);
                }else{
                    serializeObj[this.name]=[serializeObj[this.name],this.value];
                }
            }else{
                serializeObj[this.name]=this.value;
            }
        });
        return serializeObj;
    };
})(jQuery);



//一些事件
+function ($) {
    'use strict';

    $(document).delegate('.ranksong', 'click', function (e) {

        var song_id=$(this).data("song_id");
        var url=baseUrl+'/song/'+song_id;
        $(this).bjax({url: url});
    });



    $(document).delegate('.mytab [data-toggle=tab]', 'click', function (e) {

        var tar=$(this);
        tar.parent().children().removeClass("btn-info");
        tar.removeClass("btn-default").addClass("btn-info")
    })


    //歌单
    var flag=false;


    //歌曲
    $("body").delegate(".song","click",function(){

        var that=$(this);
        var songid=that.data('songid');

        //设置一个延迟
        setTimeout(function(){
            if(!flag){
                //这里是要执行的
                console.info('song点击');
                var url=baseUrl+'/song/'+songid;
                that.bjax({url: url});
            }
            flag=false;
        },100);

    });
    $("body").delegate(".song_play","click",function(){
        var that=$(this);
        var songid=that.data('songid');
        //维护标志量
        flag=true;
        server.song.playSingleSong(songid);

        console.info('song_play点击');

    });




    $("body").delegate(".songlist","click",function(){
        var that=$(this);
        var songlistid=that.data('songlistid');



        //设置一个延迟
        setTimeout(function(){
            if(!flag){
                //这里是要执行的
                console.info('songlist点击');
                var url=baseUrl+'/songlist/'+songlistid;
                that.bjax({url: url});
            }
            flag=false;
        },100);

    });
    $("body").delegate(".songlist_play","click",function(){
        var that=$(this);
        var songlistid=that.data('songlistid');
        //维护标志量
        flag=true;
        server.songlist.playSonglist(songlistid);

        console.info('songlist_play点击');

    });



    //专辑


    $("body").delegate(".album","click",function(){

        var that=$(this);

        //设置一个延迟
        setTimeout(function(){
            if(!flag){
                //这里是要执行的
                console.info('album点击');
                //进入album页面
                var albumid=that.data("albumid");
                var url=baseUrl+'/album/'+albumid;
                that.bjax({url: url});
            }
            flag=false;
        },100);

    });
    $("body").delegate(".album_play","click",function(){

        //维护标志量
        flag=true;

        console.info('album_play点击');
        //播放album中的音乐
        var albumid=$(this).data("albumid");
        //添加专辑到播放列表
        server.album.playAlbum(albumid);

    });






    //点击输入评论时，把子评论回复框关闭
    $("body").delegate(".input_comment_container","click",function(){
        $("[data-toggle=show]").myshow(true);
    });


    $('#search').bind('keypress',function(event){
        if(event.keyCode == "13")
        {
            mysearch();
        }
    });
    $("#search_btn").click(function(){
        mysearch();
    });



    //添加到歌单模板框中每一项歌单
    $("body").delegate(".add_song_to_songlist","click",function(){
        //把歌曲添加歌单
        var songlistId=$(this).data("listid");
        if(song_that_i_want_to_songlist){
            server.user.addSongToSonglist(song_that_i_want_to_songlist,songlistId);
        }
        //关闭模态框
        $('#mysonglist_modal').modal("hide");


    });

    //打开新建歌单对话框
    $("body").delegate(".newsonglist","click",function(){
        //

    });

    //按钮点击，显示添加到歌单对话框
    $("body").delegate(".addToSonglist","click",function(){
        var songId=$(this).data('song_id');
        showAddToSonglist(songId);

    });

    //红心按钮,toggleSongMyLovelist
    $("body").delegate(".toggleFromMyLovelist","click",function(){
        var songId=$(this).data('song_id');
        toggleSongMyLovelist(songId);

    });


    //点击创建歌单,弹窗新建歌单输入框
    $("body").delegate(".showNewSonglist","click",function(){

        //添加到歌单模态框关闭
        $('#mysonglist_modal').modal("hide");

        Alert.input("请输入你要创建的歌单名",function(listName){
           if($.trim(listName)==''){
               Alert.warning('歌单名不能为空');
           }else if(listName=='我喜欢'){
               Alert.warning('不能创建【我喜欢】歌单');
           }else{
               //新建歌单
               server.user.newSonglist(listName,function(data){
                   Alert.success("新建歌单成功");
                   setTimeout(function(){
                       //刷新页面
                       window.location.reload();
                   },1000);

               });

           }
        });

    });


    //点击发表评论回复
    //1-歌曲评论,2-歌单评论,3-动态评论,4-专辑评论
    $("body").delegate(".btnSubmitReply","click",function(){
        var that=$(this);
        //目标textarea
        var textarea=$($(this).data("tar_input"));
        var fatherCommentId=$(this).data("fathercommentid");
        server.user.submitComment(null,textarea.val(),fatherCommentId,1,function(){
            textarea.val('');
            //重新刷新评论
            $(that.parents(".my_comment_container").get(0)).jtemplatePag("refresh");
        });
    });


    //点击发表评论
    $("body").delegate(".btnSubmitComment","click",function(){
        var that=$(this);
        //目标textarea
        var textarea=$($(this).data("tar_input"));
        var belong=$(this).data("belong");
        var type=$(this).data("type");
        var comment_container=$(this).data("comment_container");
        server.user.submitComment(type,textarea.val(),belong,0,function(){
            textarea.val('');
            //重新刷新评论
            $(comment_container).jtemplatePag("refresh");
        });
    });



    //收藏
    $("body").delegate(".btnAddToCollect","click",function(){
        var targetId=$(this).data("target");
        var collectType=$(this).data("collecttype");
        server.user.collect(targetId,collectType);
    });

    //赞评论
    $("body").delegate(".btnPraiseComment","click",function(){
        var commentId=$(this).data("comment");
        var currentTime=new Date().getTime();
        var lastPriseTime=$(this).data("lastPriseTime");
        if(lastPriseTime&&((currentTime-lastPriseTime)<1000*60*5)){
            //
            Alert.warning("你刚赞了该评论,请等会儿再试");
            return;
        }
        $(this).data("lastPriseTime",currentTime);
        var that=$(this);

        server.open.praiseComment(commentId,function(){
            //赞后成功了对数量加1
            var praiseCount=$(that.find(".praiseCount").get(0));
            var $v=parseInt(praiseCount.text());
            praiseCount.text($v+1);
        });
    });


    //显示更多，没点击一次，获取之前未读的消息（如果没有了，显示更多隐藏）
    $("#btn_show_more_mess").click(function(){
        //获取最下面消息的时间
        var previousTime=getPreviousTime();
        //拿到消息
        server.user.showMyUreadMessPrevious(function(data){
            //追加到最后
            handleMessDown(data);

        },previousTime,5,1)
    });
    //移除，事件
    $("body").delegate(".removeMess","click",function(){
        var parent=$($(this).parent(".mess"));
        var messId=parent.data("id");
        console.info(messId);
        parent.slideUp(function(){
            //发送请求,置为已读
            readOneMess(function(data){
                //每次移除都去拿一条以前的
                getOneUreadMessPrevious();

                //还是否有消息，把全部标记为已读置为隐藏
                setReadAllStatus();
            },messId);



        });



        //数字减1
        var $el = $('.nav-user'), $n = $('.count:first', $el), $v = parseInt($n.text());
        $('.count', $el).fadeOut().fadeIn().text($v-1);



    });

    //全部设置为已读
    $("#read_all").click(function(){
        readAll();
    });



    //下载音乐
    $("body").delegate(".song_download","click",function(){

        var song_id=$(this).data('song_id');
        server.song.download(song_id);

    });

    //赞动态
    $("body").delegate(".praise_dynamic","click",function(){


        var dynamic_id=$(this).data('dynamic_id');

        var currentTime=new Date().getTime();
        var lastPriseTime=$(this).data("lastPriseTime");
        if(lastPriseTime&&((currentTime-lastPriseTime)<1000*60*5)){
            //
            Alert.warning("你刚赞了该动态,请等会儿再试");
            return;
        }
        $(this).data("lastPriseTime",currentTime);
        var that=$(this);
        server.user.praiseDynamic(dynamic_id,function(data){
            var praiseCount=$(that.find(".praiseCount").get(0));
            var $v=parseInt(praiseCount.text());
            praiseCount.text($v+1);
        });

    });

    //从歌单中移除歌曲
    $("body").delegate(".remove-from-songlist","click",function(){
        var songId=$(this).data('song_id');
        var songlistId=$(this).data('songlist_id');
        //
        Alert.confirm("是否要移除此歌曲",function(){
            server.songlist.removeSongFromSonglist(songId,songlistId,function(data){
                Alert.success("移除成功");
                setTimeout(function(){
                    //成功后，刷新当前页面
                    window.location.reload();
                },500);

            });
        })

    });


    //删除歌单dealMySonglist
    $("body").delegate(".deal-songlist","click",function(){
        var songlistId=$(this).data('songlist_id');

        //对话框
        Alert.confirm("是否要删除此歌单",function(){
            server.songlist.dealMySonglist(songlistId,function(data){
                Alert.success("歌单删除成功");
                setTimeout(function(){
                    //返回个人中心
                    var url=baseUrl+'/userHome/'+currentUserId;
                    $(this).bjax({url: url});
                },500);
            })
        });



    });

    //点击按钮发送私信
    $("body").delegate(".iwant-send-mess-btn","click",function(){
        var toUser=$(this).data('to_user');
        var messType=$(this).data('mess_type');

        //弹出输入框
        Alert.input("请输入私信的内容",function(text){
           //发送
            server.user.sendMess(toUser,text,messType,function(data){
                Alert.success("私信发送成功");
            })
        });
    });


}(jQuery);

function setReadAllStatus(){
    var $el = $('.nav-user'), $n = $('.count:first', $el), $v = parseInt($n.text());
    if($v==0){
        $("#read_all").css('display','none');
    }
}

//当前的全部设置为已读
function readAll(){
    var ehMess= $($('.nav-user').find('.list-group').get(0)).children("span");
    var messIdArray=new Array();
    $.each(ehMess,function(index,element){
        var messId=$(this).data("id");
        messIdArray.push(messId);
    });
    if(messIdArray.length==0){
        Alert.warning("当前没有未读消息了");
        return;
    }

    server.user.readMess(function(data){

        //更新消息数目

        var $el = $('.nav-user'), $n = $('.count:first', $el), $v = parseInt($n.text());
        var resultCount=0;
        if(($v-messIdArray.length)>0){
            resultCount=$v-messIdArray.length;
        }
        $('.count', $el).fadeOut().fadeIn().text(resultCount);

        Alert.success(data.message);
        //遍历，移除
        $.each(ehMess,function(index,element){

            $(this).slideUp(function(){
                $(this).remove();
                if(index==(ehMess.length-1)){
                    getUreadMessPrevious(5);
                }
            });
        });


    },messIdArray);
}

//设置一条已读消息
function readOneMess(callBack,messId){
    var messIdArray=new Array();
    messIdArray.push(messId);
    server.user.readMess(callBack,messIdArray);
}




//拿一条之前未看的信息
function getOneUreadMessPrevious(){
    getUreadMessPrevious(1);
}

//拿之前未看的信息
function getUreadMessPrevious(count){
    var previousTime=getPreviousTime();
    //拿到消息
    server.user.showMyUreadMessPrevious(function(data){
        //追加到最后
        handleMessDown(data);

    },previousTime,count,1)
}



//搜索
function mysearch(){
    var search=$('#search').val();

    //当前页面
    var url=window.location.href;
    var lastUrl=url.substring(url.lastIndexOf("/")+1);
    if(lastUrl.indexOf("search")==0){
        searchText=search;
        //当前是search页面
        refresh_search_result();
    }else{
        //跳转到search页面
        //进行url编码
        search=encodeURIComponent(search);
        var searchUrl=baseUrl+'/search?s='+search;
        $(this).bjax({
            url: searchUrl
        });
    }

}

var song_that_i_want_to_songlist;
//显示添加到歌单对话框
function showAddToSonglist(songId){
    song_that_i_want_to_songlist=songId;
    //加载歌单数据，渲染.不是第一次的话，就刷新数据
    var data=$("#mysonglist_modal").data("jtemplatePag");
    if(!data){
        $("#mysonglist_modal").jtemplatePag({
            template_url: baseUrl+"/static/templates/modal_add_songTosonglist.html",
            data_url: baseUrl+"/api/user/findMySonglist",
            dataType:2,
            isNeedPage:false,
            failCallBack:function(){
                //$('#mysonglist_modal').modal("hide");
            },
            complete:function(allData){
                //显示模态框
                $('#mysonglist_modal').modal("show");
            }

        });
    }else{
        $("#mysonglist_modal").jtemplatePag('refresh');
    }




}


//我喜欢歌单,如果原来在里面就移除，如果原来没有就添加
function toggleSongMyLovelist(songId){
    server.user.toggleSongFromLovelist(songId);
}


//初始化用户信息
function initUserMess(){
    //如果用户已登录
    if(typeof(currentUserId)=="undefined"||currentUserId==null){
        return;
    }


    $("#user_mess_group").jtemplatePag({
        template_url: baseUrl+"/static/templates/user_mess.html",
        data_url: baseUrl+"/api/mess/showMyLastMess",
        isNeedPage: false,
        pageSize:5,
        pageNumber:1,
        jTemplateSetting:{
            filter_data:false
        },
        complete:function(data,element){
            //设置信息数目
            $(".count").text(data.total);

            //是否显示更多按钮
            if(data.total<=5){
                $("#btn_show_more_mess").css('display','none');
            }

            //是否显示全部标记为已读
            if(data.total==0){
                $("#read_all").css('display','none');
            }


        }

    });
}


function addMss(){
    var $el = $('.nav-user'), $n = $('.count:first', $el), $v = parseInt($n.text());
    $('.count', $el).fadeOut().fadeIn().text($v+1);
}
//添加普通信息,上面
function addCommonMssUp(data){
    var html = template('mess_common', data);
    var $el = $('.nav-user');
    addMss();
    $(html).hide().prependTo($el.find('.list-group')).slideDown().css('display','block');

}
function addCommonMssDown(data){
    var html = template('mess_common', data);
    var $el = $('.nav-user');
    $(html).hide().appendTo($el.find('.list-group')).slideDown().css('display','block');
}



//添加公告（上面）
function addNoticeUp(data){
    var html = template('mess_notice', data);
    var $el = $('.nav-user');
    addMss();

    $(html).hide().prependTo($el.find('.list-group')).slideDown().css('display','block');

}

function addNoticeDown(data){
    var html = template('mess_notice', data);
    var $el = $('.nav-user');
    $(html).hide().appendTo($el.find('.list-group')).slideDown().css('display','block');

}

//最上面最新的信息的时间
function getLastMessTime(){
    var top = $($('.nav-user').find('.list-group').children("span:first"));
    var lastTime=top.data("time");
    return lastTime;
}
//最下面消息的时间
function getPreviousTime(){
    var last = $($('.nav-user').find('.list-group').children("span:last"));
    var previousTime=last.data("time");
    return previousTime;
}

//处理信息（down）
function handleMessDown(data) {
    var messData = data.data.rows;
    if (messData.length > 0) {
        $.each(messData, function (i, value) {
            if (this.type == 1) {
                //私信,普通信息
                addCommonMssDown(this);
            } else if (this.type == 2) {
                addNoticeDown(this);
            }
        });
    }

    if(data.data.total!=messData.length){
        //还有信息

    }else{
        //隐藏显示更多按钮
        $("#btn_show_more_mess").css('display','none');
    }
}
//处理信息(上面)
function handleMessUp(data) {
    var messData = data.data.rows;
    messData.reverse();
    if (messData.length > 0) {
        //全部标记为已读显示出来
        $("#read_all").css('display','block');
        $.each(messData, function (i, value) {
            if (this.type == 1) {
                //私信,普通信息
                addCommonMssUp(this);
            } else if (this.type == 2) {
                addNoticeUp(this);
            }
        });
    }
}
//定时器
function job(){
    if(typeof(currentUserId)=="undefined"||currentUserId==null){
        return;
    }
    setInterval(function(){
        var lastTime=getLastMessTime();
        //定时刷新信息
        //拿到最新信息
        server.user.showMyLastMess(function(data){
            handleMessUp(data);

        },lastTime)


    },1000*60);
}


function reloadShare(){
    _bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"2","bdPic":"","bdStyle":"0","bdSize":"16"},"share":{}};
    $.getScript("http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='"+~(-new Date()/36e5));
}




