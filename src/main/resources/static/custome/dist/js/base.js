/**
 *  wblog全局函数对象   var wblog = new $.wblog();
 */
$.extend({
    wblog: function () {
    }
});

/**
 * wblog alert删除  // todo: 减少耦合度,链式操作替代  2017-02-27
 * @param options
 */
// $.wblog.prototype.alert_del = function (options) {
//     swal({
//         title: options.title || '警告信息',
//         text: options.text || "确定删除吗？",
//         type: 'warning',
//         showCancelButton: true,
//         confirmButtonColor: '#3085d6',
//         cancelButtonColor: '#d33',
//         confirmButtonText: '确定',
//         cancelButtonText: '取消'
//     }).then(function () {
//         $.post(options.url, options.parame, function (result) {
//             if (result && result.success) {
//                 swal('提示信息', '删除成功', 'success');
//                 setTimeout(function () {
//                     window.location.reload();
//                 }, 2000);
//             } else {
//                 swal("提示消息", result.msg, 'error');
//             }
//         });
//     }).catch(swal.noop);
// };

/**
 * 成功弹框
 * @param options
 */
$.wblog.prototype.alertOk = function (options) {
    options = options.length ? {text:options} : ( options || {} );
    options.title = options.title || '操作成功';
    options.text = options.text;
    options.showCancelButton = false;
    options.showCloseButton = false;
    options.type = 'success';
    this.alertBox(options);
};

/**
 * 弹出成功，并在500毫秒后刷新页面
 * @param text
 */
$.wblog.prototype.alertOkAndReload = function (text) {
    this.alertOk({text:text, then:function () {
        setTimeout(function () {
            window.location.reload();
        }, 500);
    }});
};

/**
 * 警告弹框
 * @param options
 */
$.wblog.prototype.alertWarn = function (options) {
    options = options.length ? {text:options} : ( options || {} );
    options.title = options.title || '警告信息';
    options.text = options.text;
    options.timer = 3000;
    options.type = 'warning';
    this.alertBox(options);
};

/**
 * 询问确认弹框，这里会传入then函数进来
 * @param options
 */
$.wblog.prototype.alertConfirm = function (options) {
    options = options || {};
    options.title = options.title || '确定要删除吗？';
    options.text = options.text;
    options.showCancelButton = true;
    options.type = 'question';
    this.alertBox(options);
};

/**
 * 错误提示
 * @param options
 */
$.wblog.prototype.alertError = function (options) {
    options = options.length ? {text:options} : ( options || {} );
    options.title = options.title || '错误信息';
    options.text = options.text;
    options.type = 'error';
    this.alertBox(options);
};

/**
 * 公共弹框
 * @param options
 */
$.wblog.prototype.alertBox = function (options) {
    swal({
        title: options.title,
        text: options.text,
        type: options.type,
        timer: options.timer || 9999,
        background: options.background || '#fefbec',
        showCloseButton: options.showCloseButton,
        showCancelButton: options.showCancelButton,
        showLoaderOnConfirm: options.showLoaderOnConfirm || false,
        confirmButtonColor: options.confirmButtonColor || '#3085d6',
        cancelButtonColor: options.cancelButtonColor || '#d33',
        confirmButtonText: options.confirmButtonText || '确定',
        cancelButtonText: options.cancelButtonText || '取消'
    }).then(function (e) {
        options.then && options.then(e);
    }).catch(swal.noop);
};

/**
 * 全局post函数
 *
 * @param options   参数
 */
$.wblog.prototype.post = function (options) {
    var self = this;
    $.ajax({
        type: 'POST',
        url: options.url,
        data: options.data || {},
        async: options.async || false,
        dataType: 'json',
        success: function (result) {
            // self.hideLoading();
            options.success && options.success(result);
        },
        error:function(XMLHttpRequest, textStatus, errorThrown) {
            var msg = "请求失败: ";
            msg+=XMLHttpRequest.status+", "+XMLHttpRequest.readyState+", "+textStatus;
            self.alertError(msg);
        }
    });
};

$.wblog.prototype.alertInfo = function (options) {
    options = options.length ? {text:options} : ( options || {} );
    options.title = options.title || '系统提示';
    options.text = options.text;
    options.type = 'info';
    this.alertBox(options);
}
function unSupportAction(options) {
    var wblog = new $.wblog();
    wblog.alertInfo(options);
}

// /**
//  * 隐藏动画
//  */
// $.wblog.prototype.hideLoading = function () {
//     $('#tale-loading') && $('#tale-loading').hide();
// };
