// For active menu
$(function() {
	switch (menu) {
	default:
		// For activating selected category from side bar
		$('#a_' + menu).addClass('active');
		break;
	}
});

(function() {

	'use strict';

	// iPad and iPod detection
	var isiPad = function() {
		return (navigator.platform.indexOf("iPad") != -1);
	};

	var isiPhone = function() {
		return ((navigator.platform.indexOf("iPhone") != -1) || (navigator.platform
				.indexOf("iPod") != -1));
	};

	// Main Menu Superfish
	var mainMenu = function() {

		$('#fh5co-primary-menu').superfish({
			delay : 0,
			animation : {
				opacity : 'show'
			},
			speed : 'fast',
			cssArrows : true,
			disableHI : true
		});

	};

	// Date Picker

	$('#date-start, #date-end').datepicker();

	[].slice.call(document.querySelectorAll('select.cs-select')).forEach(
			function(el) {
				new SelectFx(el);
			});

	// Parallax
	var parallax = function() {
		if (!isiPad() || !isiPhone()) {
			$(window).stellar();
		}
	};

	// Offcanvas and cloning of the main menu
	var offcanvas = function() {

		var $clone = $('#fh5co-menu-wrap').clone();
		$clone.attr({
			'id' : 'offcanvas-menu'
		});
		$clone.find('> ul').attr({
			'class' : '',
			'id' : ''
		});

		$('#fh5co-page').prepend($clone);

		// click the burger
		$('.js-fh5co-nav-toggle').on('click', function() {

			if ($('body').hasClass('fh5co-offcanvas')) {
				$('body').removeClass('fh5co-offcanvas');
			} else {
				$('body').addClass('fh5co-offcanvas');
			}
			// event.preventDefault();

		});

		$('#offcanvas-menu').css('height', $(window).height());

		$(window).resize(function() {
			var w = $(window);

			$('#offcanvas-menu').css('height', w.height());

			if (w.width() > 769) {
				if ($('body').hasClass('fh5co-offcanvas')) {
					$('body').removeClass('fh5co-offcanvas');
				}
			}

		});

	}

	// Click outside of the Mobile Menu
	var mobileMenuOutsideClick = function() {
		$(document).click(
				function(e) {
					var container = $("#offcanvas-menu, .js-fh5co-nav-toggle");
					if (!container.is(e.target)
							&& container.has(e.target).length === 0) {
						if ($('body').hasClass('fh5co-offcanvas')) {
							$('body').removeClass('fh5co-offcanvas');
						}
					}
				});
	};

	// Animations

	var contentWayPoint = function() {
		var i = 0;
		$('.animate-box').waypoint(function(direction) {

			if (direction === 'down' && !$(this.element).hasClass('animated')) {

				i++;

				$(this.element).addClass('item-animate');
				setTimeout(function() {

					$('body .animate-box.item-animate').each(function(k) {
						var el = $(this);
						setTimeout(function() {
							el.addClass('fadeInUp animated');
							el.removeClass('item-animate');
						}, k * 50, 'easeInOutExpo');
					});

				}, 100);

			}

		}, {
			offset : '85%'
		});
	};

	var stickyBanner = function() {
		var $stickyElement = $('.sticky-banner');
		var sticky;
		if ($stickyElement.length) {
			sticky = new Waypoint.Sticky({
				element : $stickyElement[0],
				offset : 0
			})
		}
	};

	// Document on load.
	$(function() {
		mainMenu();
		parallax();
		offcanvas();
		mobileMenuOutsideClick();
		contentWayPoint();
		stickyBanner();
	});

}());

// For populating vehicle to the vehicle list table
var $table = $('#vehicleListTable');
// Execute below only where we have above mentioned table
if ($table.length) {
	// Creating WebService URL
	var jsonUrl = '';
	if (window.categoryId == '') {
		// Means User is asking for all the Products
		jsonUrl = window.contextRoot + '/json/data/all/vehicles';
	} else {
		jsonUrl = window.contextRoot + '/json/data/category/'
				+ window.categoryId + '/vehicles';
	}
	populateTable(jsonUrl);

}

/*
 * // Calling REST API on radio button click $('input[name=myradio]').click(
 * function() { var selectedRadioButton =
 * $('input[name=myradio]:checked').val(); window.selectedRadioButton =
 * selectedRadioButton; var jsonUrl = ''; if (window.categoryId == '') { //
 * Means User is asking for all the Products jsonUrl = window.contextRoot +
 * '/json/data/all/vehicles/' + selectedRadioButton;
 *  } else { jsonUrl = window.contextRoot + '/json/data/category/' +
 * window.categoryId + '?fuelType=' + selectedRadioButton; }
 * $table.DataTable().destroy(); populateTable(jsonUrl); });
 */

// For Populating Vehicle list table
function populateTable(jsonUrl) {
	$table.DataTable({
		lengthMenu : [ [ 3, 5, 10, -1 ],
				[ '3 Records', '5 Records', '10 Records', 'All Records' ] ],
		pageLength : 5,

		// AJAX Call for calling WebService and getting data
		ajax : {
			url : jsonUrl,
			dataSrc : '',
		},
		// For Printing Column
		columns : [
				{
					data : 'code',
					bSortable : false,
					mRender : function(data, type, row) {
						return '<img class="dataTableImg" src="#" />';
					}
				},
				{
					data : 'name'
				},
				{
					data : 'brand',
					bSortable : false
				},
				{
					data : 'rentCharge',
					mRender : function(data, type, row) {
						return '&#8377; ' + data;
					}
				},
				{
					data : 'fuelType',
					bSortable : false
				},
				{
					data : 'mileage',
					mRender : function(data, type, row) {
						return data + ' per/lit';
					}
				},
				{
					data : 'id',
					bSortable : false,
					mRender : function(data, type, row) {
						// URL to show the Product
						var str = '';
						str += '<a href="#" class="btn btn-primary">'
								+ '<i class="fa fa-eye"></i></a>' + ' ';
						str += '<a href="#"class="btn btn-success">'
								+ '<i class="fas fa-taxi"></i>';

						return str;
					}
				} ],
		responsive : true
	});
}

$(document).ready(function() {
	window.filter_query = '';

	// For removing underline from anchor tag
	$('a').hover(

	function() {
		$(this).css({
			"text-decoration" : "none",
		});
	});

});
// For getting clicked values of filters
$('.search_filters').change(
		function(e) {
			var jsonUrl = '';
			var value = $(this).val();
			var name = $(this).attr('name');
			// alert('Clicked :'+value+" and its name :"+name);

			if (window.filter_query === '') {
				window.filter_query = window.filter_query + '?' + name + '='
						+ value;
			} else {
				window.filter_query = window.filter_query + '&' + name + '='
						+ value;
			}

			// alert("Create query :"+window.filter_query);

			jsonUrl = window.contextRoot + '/json/data/searchFilters'
					+ window.filter_query;
			alert(jsonUrl);
			$table.DataTable().destroy();
			populateTable(jsonUrl);

		});

// For time picker library
var timepicker = new TimePicker('time', {
	lang : 'en',
	theme : 'dark'
});
timepicker.on('change', function(evt) {

	var value = (evt.hour || '00') + ':' + (evt.minute || '00');
	evt.element.value = value;

});

// For populating Available City list on AJAX call

