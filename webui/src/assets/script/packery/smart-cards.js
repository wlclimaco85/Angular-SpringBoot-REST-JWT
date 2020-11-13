Packery.prototype.getShiftPositions = function(attrName) {
	attrName = attrName || 'id';
	var _this = this;

	this.items = this.items.filter(function(item) {
		var selector = '[desktop-card-id="' + item.element.getAttribute(attrName) + '"]';
		var itemElem = document.querySelector(selector);

		return itemElem != null
	});

	return {
		windowWidth : $(window).width(),
		positions : this.items.map(function(item) {
			return {
				attr : item.element.getAttribute(attrName),
				x : item.rect.x
			}
		})
	};
};

Packery.prototype.initShiftLayout = function(positions, attr) {
	if (!positions) {
		// if no initial positions, run packery layout
		this.layout();

		var dragPositions = $('.desktop-cards-container').packery('getShiftPositions', 'desktop-card-id');
		localStorage.setItem('dragPositions', JSON.stringify(dragPositions));
		return;
	}
	// parse string to JSON
	if (typeof positions == 'string') {
		try {
			positions = JSON.parse(positions);
		} catch (error) {
			console.error('JSON parse error: ' + error);
			this.layout();
			return;
		}
	}

	attr = attr || 'id'; // default to id attribute
	this._resetLayout();
	// set item order and horizontal position from saved positions
	this.items = positions.map(function(itemPosition) {
		var selector = '[' + attr + '="' + itemPosition.attr + '"]'
		var itemElem = this.element.querySelector(selector);
		var item = this.getItem(itemElem);
		item.rect.x = itemPosition.x;
		return item;
	}, this);
	
	this.shiftLayout();
};

function loadSmartCards() {

	var $container = $('.desktop-cards-container').packery({
		itemSelector : '.desktop-card',
		columnWidth : 190,
		gutter : 10
	});

	var $items = $container.find('.desktop-card').draggable({
		 iframeFix: true
	 });

	$container.packery( 'bindUIDraggableEvents', $items );

	// save drag positions on event
	$container.on('dragItemPositioned', function() {
		// save drag positions
		var dragPositions = $container.packery('getShiftPositions', 'desktop-card-id');
		
		localStorage.setItem('dragPositions', JSON.stringify(dragPositions));
	});
	
	initLayoutSmartCards();
}

function initLayoutSmartCards() {
	var $container = $('.desktop-cards-container');
	$container.css('width', getDesktopCardContainerWidth);
	
	//get saved dragged positions
	var dragPositions = JSON.parse(localStorage.getItem('dragPositions'));

	var windowWidth = null;
	var initPositions = [];
	var countCards = $(".desktop-card").size();
	var countCardsSaved = 0;

	if (dragPositions != null && !jQuery.isEmptyObject(dragPositions)) {
		windowWidth = dragPositions.windowWidth;
		initPositions = dragPositions.positions;
		countCardsSaved = initPositions.length; 
		initPositions = initPositions.filter(function(itemPosition) {
			var selector = '[desktop-card-id="' + itemPosition.attr + '"]';
			var itemElem = document.querySelector(selector);

			return itemElem != null
		});
	}

	if (windowWidth != $(document).width()
			|| countCards != countCardsSaved) {
		initPositions = null;
		localStorage.setItem('dragPositions', '{}');
	}
	
	// init layout with saved positions
	$container.packery('initShiftLayout', initPositions, 'desktop-card-id');
}

function layoutSmartCards(){
	initLayoutSmartCards();
}

function getDesktopCardContainerWidth() {
	var width = Math.round(($(document).width() - $(document).width() * 0.05));
	return width = width - (width % 200);
}