export default class Story {
	/**
	 * create a new story based on the meta passed in argument
	 * @constructor
	 * @param {object} meta - the meta data for story
	 */
	constructor (meta) {
		this.name = meta.name;
		this.description = meta.description;
		this.triggeredAt = meta.triggeredAt;
		this.state = meta.state;
	}

	/**
	 * isUnlockYet checks if this story is ready to be unlocked yet
	 * @param {number} value - the resource value at the moment
	 * @return {boolean} if this story is unlockable
	 */
	isUnlockYet (value) {
		// TODO: implement based on doc
		return false;
	}

	/**
	 * unlock simply unlock the story to visible state
	 */
	unlock () {
		// TODO: change the story state to "visible"
	}
}
